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
 * Servlet implementation class ProductSelect
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<LMONKEY_PRODUCT> list=IMONKEY_PRODUCTDao.selectAll();
		ArrayList<LMONKEY_CATEGORY> flist=IMONKEY_CATEGORYDao.selectCat("father");
		ArrayList<LMONKEY_CATEGORY> clist=IMONKEY_CATEGORYDao.selectCat("child");
		request.setAttribute("productlist", list);
		request.setAttribute("flist", flist);
		request.setAttribute("clist", clist);
		//System.out.print(list);
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}

	

}
