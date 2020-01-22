package com.imonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.service.IMonkey_UserDao;

/**
 * Servlet implementation class DoUserDelete
 */
@WebServlet("/manage/admin_douserdelete")
public class DoUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int count=0;
		int cpage=1;
		count=IMonkey_UserDao.deleteUserById(request.getParameter("id"));
		String cp=request.getParameter("cp");
		if(cp!=null){
			cpage=Integer.parseInt(cp);
			
		}
		
		//request.setAttribute("cpage", cpage);
		if(count>0){
			response.sendRedirect("admin_douserselect?cp="+cpage);
			//System.out.print(cp);
		}else{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('删除失败！');");
			out.write("location.herf='manage/douserselect?cp="+cpage+"'");
			out.write("</script>");
			
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int count=0;
		int cpage=1;
		
		String [] ids = request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++){
			IMonkey_UserDao.deleteUserById(ids[i]);
			count++;
			//System.out.print(count);
			System.out.println(ids[i]);
		}
		
		
		response.sendRedirect("admin_douserselect");
		
		
	
	}

	

}
