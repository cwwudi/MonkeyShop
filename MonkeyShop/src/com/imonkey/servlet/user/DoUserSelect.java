package com.imonkey.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imonkey.entity.LMONKEY_USER;
import com.imonkey.service.IMonkey_UserDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage=1;//当前页
		int count=5;//每页显示数
		
		String cp=request.getParameter("cp");
		String keywords=request.getParameter("keywords");
		if(cp!=null){
			cpage=Integer.parseInt(cp);
		}
		int[] arr=IMonkey_UserDao.totalPage(count,keywords);
		
		//获取用户
		ArrayList<LMONKEY_USER> userlist=IMonkey_UserDao.selectAll(cpage,count,keywords);
		//放置于请求对象的域
		request.setAttribute("userlist", userlist);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		if(keywords!=null){
			request.setAttribute("keywords", "&keywords="+keywords);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		//System.out.print(cp);
	}

}
