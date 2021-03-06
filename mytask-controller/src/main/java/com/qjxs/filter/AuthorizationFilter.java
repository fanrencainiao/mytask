package com.qjxs.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Maps;
import com.qjxs.common.login.LoginSign;
import com.qjxs.common.utils.AuthServiceUtils;
import com.qjxs.common.utils.ReqUtil;
import com.qjxs.common.utils.ResponseUtil;
import com.qjxs.common.utils.StringUtil;
import com.qjxs.domain.User;
import com.qjxs.utils.KSessionUtil;


@WebFilter(filterName = "authorizationfilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "enable", value = "true") })
public class AuthorizationFilter implements Filter {

	private Map<String, String> requestUriMap;
	@Autowired
	@Qualifier(value = "afp")
	private AuthorizationFilterProperties afp;
	private Log logger = LogFactory.getLog(AuthorizationFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		if (null == requestUriMap) {
			requestUriMap = Maps.newHashMap();

			for (String requestUri : afp.getRequestUriList()) {
				requestUriMap.put(requestUri, requestUri);
			}
		}

//		 if (!enable) {
//		 arg2.doFilter(arg0, arg1);
//		 return;
//		 }

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String accessToken = request.getHeader("access_token");
//		long time = NumberUtils.toLong(request.getParameter("time"), 0);
		long time = 0;
		String secret = request.getParameter("secret");
		// //是否检验接口
		// boolean falg=StringUtils.isNotBlank(secret)&&0<time;
		String requestUri = request.getRequestURI();
		//
		 if("/favicon.ico".equals(requestUri))
		 return;

		// DEBUG**************************************************DEBUG
		StringBuffer sb = new StringBuffer();
		sb.append(request.getMethod()).append(" 请求：" + request.getRequestURI());

		logger.info(sb.toString());
		// DEBUG**************************************************DEBUG
		
		// 如果访问的是控制台或资源目录
		if (requestUri.startsWith("/console")||requestUri.startsWith("/static")||requestUri.startsWith("/templates")||requestUri.startsWith("/v2") ||requestUri.startsWith("/swagger-resources")|| requestUri.startsWith("/toPage") || requestUri.endsWith(".js") || requestUri.endsWith(".html")
				|| requestUri.endsWith(".css") || requestUri.endsWith(".jpg")|| requestUri.endsWith(".png")||requestUri.endsWith(".json")||requestUri.endsWith(".woff")||requestUri.endsWith(".ttf")|| requestUri.startsWith("/test")) {
			User obj =(User) request.getSession().getAttribute(LoginSign.LOGIN_USER_KEY);
			// 用户已登录或访问资源目录或访问登录页面
			System.out.println(obj);
			if ((null != obj&&obj.getId()!=null)||requestUri.startsWith("/console/logout")||requestUri.startsWith("/console/login")||requestUri.startsWith("/templates/console/login.html")||requestUri.startsWith("/static")) {
				arg2.doFilter(arg0, arg1);
				return;
			} else
				response.sendRedirect("/templates/console/login.html");
			
		} else {
			if (requestUri.equals("/getImgCode")) {
				arg2.doFilter(arg0, arg1);
				return;
			}

			// 需要登录
			if (isNeedLogin(request.getRequestURI())) {
				// 请求令牌是否包含
				if (StringUtil.isEmpty(accessToken)) {
					logger.info("不包含请求令牌");
					int tipsKey = 20006;
					renderByErrorKey(response, tipsKey, "不包含请求令牌");
				} else {
					String userId = getUserId(accessToken);
					// 请求令牌是否有效
					if (null == userId) {
						logger.info("请求令牌无效或已过期...");
						int tipsKey = 20007;
						renderByErrorKey(response, tipsKey, "请求令牌无效或已过期...");
					} else {

						if (!AuthServiceUtils.authRequestApi(userId, time, accessToken, secret, requestUri)) {
							renderByError(response, "授权认证失败");
							return;
						}

						ReqUtil.setLoginedUserId(Integer.valueOf(userId));
						arg2.doFilter(arg0, arg1);
						return;
					}
				}
			} else {
				/**
				 * 校验没有登陆的接口
				 */
				if (!AuthServiceUtils.authOpenApiSecret(time, secret)) {
					renderByError(response, "授权认证失败");
					return;
				}
				arg2.doFilter(arg0, arg1);
			}
		}
	}

	private boolean isNeedLogin(String requestUri) {
		return !requestUriMap.containsKey(requestUri.trim());
	}

	private String getUserId(String _AccessToken) {
		String userId = null;

		try {
			userId = KSessionUtil.getUserIdBytoken(_AccessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userId;
	}

	private static final String template = "{\"code\":%1$s,\"msg\":\"%2$s\"}";

	private static void renderByErrorKey(ServletResponse response, int tipsKey, String tipsValue) {

		String s = String.format(template, tipsKey, tipsValue);

		ResponseUtil.output(response, s);
	}

	private static void renderByError(ServletResponse response, String errMsg) {

		String s = String.format(template, 0, errMsg);

		ResponseUtil.output(response, s);
	}

}
