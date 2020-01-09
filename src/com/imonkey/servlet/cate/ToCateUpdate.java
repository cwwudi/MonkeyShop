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
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		ArrayList<LMONKEY_CATEGORY> list=IMONKEY_CATEGORYDao.selectAll();

		LMONKEY_CATEGORY cate=IMONKEY_CATEGORYDao.selectByid(id);
		
		request.setAttribute("cate", cate);
		request.setAttribute("categorylist", list);
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}

	

}
