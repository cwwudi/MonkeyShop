package com.imonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imonkey.entity.LMONKEY_USER;
import com.imonkey.service.IMonkey_UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userid=request.getParameter("userId");
		String password=request.getParameter("password");
		int count=IMonkey_UserDao.selectByNM(userid,password);
		if(count>0){
			HttpSession session=request.getSession();
			
			LMONKEY_USER user =IMonkey_UserDao.selectByid(userid);
			session.setAttribute("user", user);
			session.setAttribute("isLogin", "1");
			response.sendRedirect("index.jsp");
			
			
		}else{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('登录失败');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
