package com.imonkey.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.service.IMONKEY_PRODUCTDao;

/**
 * Servlet implementation class DoProductDelete
 */
@WebServlet("/manage/admin_doproductdelete")
public class DoProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		int count =IMONKEY_PRODUCTDao.deleteById(Integer.parseInt(id));
		if(count>0){
			response.sendRedirect("admin_productselect");
		}else{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('删除失败！');");
			out.write("location.herf='manage/admin_productselect");
			out.write("</script>");
		}
		
	}

	

}
