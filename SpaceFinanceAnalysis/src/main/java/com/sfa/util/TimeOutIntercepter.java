package com.sfa.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeOutIntercepter implements HandlerInterceptor {
	public String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);

		if (StringUtils.isNotBlank(requestUrl)) {
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					return true;
				}
			}
		}
		// session持续时间
		int maxInactiveInterval = session.getMaxInactiveInterval();
		// session创建时间
		long creationTime = session.getCreationTime();
		// session最新链接时间
		long lastAccessedTime = session.getLastAccessedTime();

		System.out.println("-----> maxInactiveInterval: " + maxInactiveInterval);
		System.out.println("-----> creationTime: " + creationTime);
		System.out.println("-----> lastAccessedTime: " + lastAccessedTime);

		// 从session获取上次链接时间
		Long operateTime = (Long) session.getAttribute("operateTime");
		System.out.println("-----> operateTime: " + operateTime);

		// 如果operateTime是空，说明是第一次链接，对operateTime进行初始化
		if (operateTime == null) {
			session.setAttribute("operateTime", lastAccessedTime);
			return true;
		} else {
			// 计算最新链接时间和上次链接时间的差值
			int intervalTime = (int) ((lastAccessedTime - operateTime) / 1000);
			System.out.println("-----> intervalTime: " + intervalTime);
			// 如果超过十秒没有交互的话，就跳转到超时界面
			if (intervalTime > 10) {
				response.sendRedirect("http://www.baidu.com");
				return true;
			}
			// 更新operateTime
			session.setAttribute("operateTime", lastAccessedTime);
			return true;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
