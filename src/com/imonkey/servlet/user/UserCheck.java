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
 * Servlet implementation class UserCheck
 */
@WebServlet("/usercheck")
public class UserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userid=request.getParameter("name");
		LMONKEY_USER u=IMonkey_UserDao.selectByid(userid);
		PrintWriter out= response.getWriter();
		
		if(u!=null){
			out.print("false");
		}else{
			out.print("true");
		}
		out.close();
	}

}
