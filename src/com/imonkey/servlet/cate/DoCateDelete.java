package com.imonkey.servlet.cate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.service.IMONKEY_CATEGORYDao;

/**
 * Servlet implementation class DoCateDelete
 */
@WebServlet("/manage/admin_docatedelete")
public class DoCateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int count=IMONKEY_CATEGORYDao.deleteCateById(id);
		if(count>0){
			response.sendRedirect("admin_cateselete");
		}
	}

	

}
