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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单内容
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String repassword=request.getParameter("rePassword");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		//创建用户实体
		LMONKEY_USER u=new LMONKEY_USER(username,name,password,sex,birthday,null,email,mobile,address,1);
		
		//加入到数据库中
		int count=IMonkey_UserDao.insert(u);
		//成功或失败重定向
		if(count>0){
			response.sendRedirect("admin_douserselect");
		}
		else{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('添加失败');");
			out.write("location.herf='admin_useradd.jsp';");
			out.write("</script>");
			
		}
	}

}
