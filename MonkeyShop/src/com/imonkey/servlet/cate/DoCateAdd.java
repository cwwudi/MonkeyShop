package com.imonkey.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.service.IMONKEY_CATEGORYDao;

/**
 * Servlet implementation class DoCateAdd
 */
@WebServlet("/manage/admind_docateadd")
public class DoCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String parentId=request.getParameter("parentId");
		String cateName=request.getParameter("cateName");
		int count=IMONKEY_CATEGORYDao.insert(cateName,parentId);
		PrintWriter out=response.getWriter();
		if(count>0){
			response.sendRedirect("admin_cateselete");
		}
		else{
			
			out.write("<script>");
			out.write("alert('添加失败');");			
			out.write("</script>");
			out.close();
			
		}
		
	}

}
