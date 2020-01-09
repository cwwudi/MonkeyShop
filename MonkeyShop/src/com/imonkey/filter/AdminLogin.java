package com.imonkey.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
@WebFilter("/manage/*")
public class AdminLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	
		HttpSession session =req.getSession();
		String isAdminLogin=(String)session.getAttribute("isAdminLogin");
		String uri=req.getRequestURI();
		//System.out.print(isAdminLogin);
		if(uri.contains("admin_")){
			if(isAdminLogin=="1"){
				chain.doFilter(request, response);
			}else{
				PrintWriter out=resp.getWriter();
				out.write("<script>");
				out.write("alert('请先登录');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
		}else{
			chain.doFilter(request, response);
		}
		
		
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
