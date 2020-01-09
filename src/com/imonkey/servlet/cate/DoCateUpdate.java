package com.imonkey.servlet.cate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_CATEGORY;
import com.imonkey.service.IMONKEY_CATEGORYDao;

/**
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int parentId=Integer.parseInt(request.getParameter("parentId"));
		String cateName=request.getParameter("cateName");
		int cateId=Integer.parseInt(request.getParameter("id"));
		LMONKEY_CATEGORY category=new LMONKEY_CATEGORY(cateId, cateName, parentId);
		int count=IMONKEY_CATEGORYDao.updateCateById(category);
		if(count>0){
			response.sendRedirect("admin_cateselete");
		}
	}

}
