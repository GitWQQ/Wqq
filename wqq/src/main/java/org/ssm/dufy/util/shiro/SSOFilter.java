package org.ssm.dufy.util.shiro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class SSOFilter implements Filter{
	
	private String serverLoginUrl;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
		String reqUrl=httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"
		+httpServletRequest.getServerPort()+httpServletRequest.getContextPath()+httpServletRequest.getRequestURI();
		Object username=httpServletRequest.getSession().getAttribute("username");
		if(username!=null){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		String sid=httpServletRequest.getParameter("SHAREJSESSIONID");
		if(StringUtils.isNotEmpty(sid)){
			Cookie cookie=new Cookie("SHAREJSESSIONID",sid);
			cookie.setPath("/");
			httpServletResponse.addCookie(cookie);
            String html = "<html><head><script type=\"text/javascript\">location.href='" + reqUrl + "'</script></head><body></body></html>";
            byte[] bytes=html.getBytes();
            httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
            httpServletResponse.getOutputStream().write(bytes);
            httpServletResponse.getOutputStream().flush();
            httpServletResponse.getOutputStream().close();
            return;
		}
		httpServletResponse.sendRedirect(serverLoginUrl+"?redirectUrl"+reqUrl);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public String getServerLoginUrl() {
		return serverLoginUrl;
	}

	public void setServerLoginUrl(String serverLoginUrl) {
		this.serverLoginUrl = serverLoginUrl;
	}
	

}
