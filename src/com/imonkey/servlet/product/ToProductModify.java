package com.imonkey.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_CATEGORY;
import com.imonkey.entity.LMONKEY_PRODUCT;
import com.imonkey.service.IMONKEY_CATEGORYDao;
import com.imonkey.service.IMONKEY_PRODUCTDao;

/**
 * Servlet implementation class ToProductModify
 */
@WebServlet("/manage/admin_toproductmodify")
public class ToProductModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		ArrayList<LMONKEY_CATEGORY> flist=IMONKEY_CATEGORYDao.selectCat("father");
		ArrayList<LMONKEY_CATEGORY> clist=IMONKEY_CATEGORYDao.selectCat("child");
		LMONKEY_PRODUCT p=IMONKEY_PRODUCTDao.selectById(Integer.parseInt(id));
		request.setAttribute("product", p);
		request.setAttribute("father", flist);
		request.setAttribute("child", clist);
		request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);
	}

	

}
