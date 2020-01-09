package com.imonkey.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_USER;
import com.imonkey.service.IMonkey_UserDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count=0;
		int cpage=1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单字段
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String repassword=request.getParameter("rePassword");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		LMONKEY_USER u=new LMONKEY_USER(username,name,password,sex,birthday,null,email,mobile,address,1);
		count=IMonkey_UserDao.updaateUserById(u);
		String cp=request.getParameter("cpage");
		if(cp!=null){
			cpage=Integer.parseInt(cp);
			
		}
		
		if(count>0){
			response.sendRedirect("admin_douserselect?cp="+cpage);
		}
	}

}
