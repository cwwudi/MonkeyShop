package com.imonkey.servlet.home;

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
 * Servlet implementation class SelectProduct
 */
@WebServlet("/selectproduct")
public class SelectProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		ArrayList<LMONKEY_CATEGORY> flist=IMONKEY_CATEGORYDao.selectCat("father");
		ArrayList<LMONKEY_CATEGORY> clist=IMONKEY_CATEGORYDao.selectCat("child");
		LMONKEY_CATEGORY category=IMONKEY_CATEGORYDao.selectByid(id);
		request.setAttribute("father", flist);
		request.setAttribute("child", clist);
		request.setAttribute("category", category);
		if(category.getCATE_PARENT_ID()!=0){
			LMONKEY_CATEGORY fcategory=IMONKEY_CATEGORYDao.selectByid(Integer.toString(category.getCATE_PARENT_ID()));
			request.setAttribute("fcategory", fcategory);
			//System.out.println(fcategory);
		}
		//System.out.println(flist);System.out.println(clist);
		request.getRequestDispatcher("proList.jsp").forward(request, response);
		
		
	}

	

}
