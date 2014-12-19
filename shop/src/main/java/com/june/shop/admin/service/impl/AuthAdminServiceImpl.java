package com.june.shop.admin.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.june.shop.admin.model.AdminUserInfo;
import com.june.shop.admin.model.AdminUserRoleInfo;
import com.june.shop.admin.repository.AdminUserRepository;
import com.june.shop.admin.service.AuthAdminService;

@Service
public class AuthAdminServiceImpl implements AuthAdminService, UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(AuthAdminServiceImpl.class);	
	private AdminUserRepository adminUserRepository;
	  
	
    @Autowired
    public AuthAdminServiceImpl(AdminUserRepository adminUserRepository) {
        
        this.adminUserRepository = adminUserRepository;
    }

	//@Transactional
	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		/**DB테이블 완성되면 datasource 로교체할 것*/
		//AdminUserInfo userInfos = adminUserRepository.getUserByLogin(userId);
		AdminUserInfo userInfos = new AdminUserInfo();
		userInfos.setUser_id("admin");
		userInfos.setPassword("1");
		logger.debug("===========]adminId[========{}",userId);
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		//List<AdminUserRoleInfo> userRoleInfos = adminUserRepository.getUserRoleByLogin(userInfos.getSeq());
		
		List<AdminUserRoleInfo> userRoleInfos = new ArrayList<AdminUserRoleInfo>();
		AdminUserRoleInfo adminUserRoleInfo = new AdminUserRoleInfo();
		adminUserRoleInfo.setRole("ROLE_ADMIN");
		userRoleInfos.add(adminUserRoleInfo);
		
		for (AdminUserRoleInfo userRoleInfo :userRoleInfos){
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(userRoleInfo.getRole());
			authorities.add(userAuthority);
		}
		
		/**유저 권한 1:1 매핑으로 수정*/
		/*RoleInfo roleInfo = userInfos.getUserRoleInfo().getRoleInfo();
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(roleInfo.getRole());
		authorities.add(userAuthority);*/
	
		/*SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(details.getRole());*/
		/*SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(
				"ROLE_ADMIN");
		
		authorities.add(userAuthority);*/
		
		/*if (details.getRole().equals("user"))
			authorities.add(userAuthority);
		else if (details.getRole().equals("admin")) {
			authorities.add(userAuthority);
			authorities.add(adminAuthority);
		}*/
		UserDetails user = new User(userInfos.getUser_id(),
				userInfos.getPassword(), true, true, true, true, authorities);
		return user;
	}
}
