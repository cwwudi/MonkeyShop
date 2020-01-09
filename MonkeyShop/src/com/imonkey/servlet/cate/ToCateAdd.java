package com.imonkey.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_CATEGORY;
import com.imonkey.service.IMONKEY_CATEGORYDao;

/**
 * Servlet implementation class ToCateAdd
 */
@WebServlet("/manage/admin_tocateadd")
public class ToCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LMONKEY_CATEGORY> list=IMONKEY_CATEGORYDao.selectAll();
		request.setAttribute("categorylist", list);
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
	}

	

}
