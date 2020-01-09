package com.imonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCode
 */
@WebServlet("/checkcode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String code=request.getParameter("code");
		HttpSession session=request.getSession();
		String sysCode=(String)session.getAttribute("code");
		PrintWriter out= response.getWriter();
		if(code.equals(sysCode)){
			out.print("true");
		}else{
			out.print("false");
		}
		out.close();
		
		
		
	}

	

}
