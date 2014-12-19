package com.june.shop.site.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class LoginSuccessHandlerImpl extends
		SimpleUrlAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginSuccessHandlerImpl.class);
	private RequestCache requestCache = new HttpSessionRequestCache();

	/*@Autowired
	UserRepository userRepository;*/

	public LoginSuccessHandlerImpl() {
	}

	public LoginSuccessHandlerImpl(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal != null && principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			//UserInfo userInfos = userRepository.getUser(userName);
			/** 패스워드는 세션에 담지 않는다 */
			//userInfos.setPassword("");
			// userInfos.getUserRoleInfo();

			//Login login = new Login();
			boolean isLogin = true;

			/*login.setLogin(isLogin);
			login.setUserInfo(userInfos);*/
			//request.getSession().setAttribute("loginInfo", login);
		}
		// HttpSessionRequestCache
		/*
		 * SavedRequest savedRequest = (SavedRequest)
		 * request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
		 * String targetUrl = savedRequest.getRedirectUrl(); //handle(request,
		 * response, authentication);
		 * getRedirectStrategy().sendRedirect(request, response, targetUrl);
		 * clearAuthenticationAttributesCus(request);
		 */

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest == null) {
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}
		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParameter != null && StringUtils.hasText(request
						.getParameter(targetUrlParameter)))) {
			requestCache.removeRequest(request, response);
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}

		clearAuthenticationAttributes(request);

		// Use the DefaultSavedRequest URL
		String targetUrl = savedRequest.getRedirectUrl();
		logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);

		// getRedirectStrategy().sendRedirect(request, response, "");
		// .sendRedirect(request, response, url);

	}

	protected final void clearAuthenticationAttributesCus(
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
