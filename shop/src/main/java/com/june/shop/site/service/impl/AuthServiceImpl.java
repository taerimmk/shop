package com.june.shop.site.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.june.shop.site.model.UserInfo;
import com.june.shop.site.model.UserRoleInfo;
import com.june.shop.site.service.AuthService;


@Service
public class AuthServiceImpl implements AuthService, UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);	
	/*private UserRepository UserRepository;
	  
	
    @Autowired
    public AuthServiceImpl(UserRepository UserRepository) {
        
        this.UserRepository = UserRepository;
    }*/

	//@Transactional
	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		logger.debug("===========]userId[========{}",userId);
		//UserInfo userInfos = UserRepository.getUserByLogin(userId);
		UserInfo userInfos = new UserInfo();
		userInfos.setUser_id("user");
		userInfos.setPassword("1");
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		//List<UserRoleInfo> userRoleInfos = UserRepository.getUserRoleByLogin(userInfos.getSeq());
		
		List<UserRoleInfo> userRoleInfos = new ArrayList<UserRoleInfo>();
		UserRoleInfo UserRoleInfo = new UserRoleInfo();
		UserRoleInfo.setRole("ROLE_USER");
		userRoleInfos.add(UserRoleInfo);
		
		for (UserRoleInfo userRoleInfo :userRoleInfos){
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(userRoleInfo.getRole());
			authorities.add(userAuthority);
		}
		
		/**유저 권한 1:1 매핑으로 수정*/
		/*RoleInfo roleInfo = userInfos.getUserRoleInfo().getRoleInfo();
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(roleInfo.getRole());
		authorities.add(userAuthority);*/
	
		/*SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(details.getRole());*/
		/*SimpleGrantedAuthority Authority = new SimpleGrantedAuthority(
				"ROLE_");
		
		authorities.add(userAuthority);*/
		
		/*if (details.getRole().equals("user"))
			authorities.add(userAuthority);
		else if (details.getRole().equals("")) {
			authorities.add(userAuthority);
			authorities.add(Authority);
		}*/
		UserDetails user = new User(userInfos.getUser_id(),
				userInfos.getPassword(), true, true, true, true, authorities);
		return user;
	}
}
