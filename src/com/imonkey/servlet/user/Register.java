package com.imonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_USER;
import com.imonkey.service.IMonkey_UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单内容
		String userId=request.getParameter("userId");
		String UserName=request.getParameter("UserName");
		String password=request.getParameter("password");
		String repassword=request.getParameter("rePassword");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		//创建用户实体
		LMONKEY_USER u=new LMONKEY_USER(userId,UserName,password,sex,birthday,null,email,mobile,address,1);
		//加入到数据库中
		int count=IMonkey_UserDao.insert(u);
		if(count>0){
			response.sendRedirect("login.jsp");
		}
		else{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('注册失败');");
			out.write("location.herf='reg.jsp';");
			out.write("</script>");
			out.close();
		}		
				
	}

}
