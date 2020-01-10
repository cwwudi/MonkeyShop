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
 * Servlet implementation class ToProductAdd
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<LMONKEY_CATEGORY> flist=IMONKEY_CATEGORYDao.selectCat("father");
		ArrayList<LMONKEY_CATEGORY> clist=IMONKEY_CATEGORYDao.selectCat("child");
		request.setAttribute("father", flist);
		request.setAttribute("child", clist);
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
	}

	

}
