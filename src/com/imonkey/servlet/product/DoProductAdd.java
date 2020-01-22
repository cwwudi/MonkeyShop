package com.imonkey.servlet.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imonkey.entity.LMONKEY_PRODUCT;
import com.imonkey.service.IMONKEY_PRODUCTDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String fm=null;
		 	request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        HashMap<String, String> hm=new HashMap<String, String>();
	        
			//1、创建一个DiskFileItemFactory工厂
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        //2、创建一个文件上传解析器
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        //解决上传文件名的中文乱码
	        upload.setHeaderEncoding("UTF-8"); 
			factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
			File linshi = new File("E:\\linshi");//当超过500K的时候，存到一个临时文件夹中
			factory.setRepository(linshi);
			upload.setSizeMax(1024 * 1024 * 50);//设置上传的文件总的大小不能超过5M
			try {
				// 1. 得到 FileItem 的集合 items
				List<FileItem> /* FileItem */items = upload.parseRequest(request);
	 
				// 2. 遍历 items:
				for (FileItem item : items) {
					// 若是一个一般的表单域, 打印信息
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						hm.put(name, value);
						//System.out.println(name + ": " + value);
						
						
					}
					// 若是文件域则把文件保存到 e:\\files 目录下.
					else {
						String fileName = item.getName();
						String strArry[]=fileName.split("\\.");
						String hz=strArry[strArry.length-1];
						fm=new Date().getTime()+"."+hz;
						long sizeInBytes = item.getSize();
						//System.out.println(fileName);
						//System.out.println(sizeInBytes);
	 
						InputStream in = item.getInputStream();
						byte[] buffer = new byte[1024];
						int len = 0;
						
						fileName = "D:\\images\\" + fm;//文件最终上传的位置
						
						//System.out.println(fileName);
						//System.out.println();
						OutputStream out = new FileOutputStream(fileName);
						
						while ((len = in.read(buffer)) != -1) {
							out.write(buffer, 0, len);
						}
						//System.out.println(new Date().getTime());
						out.close();
						in.close();
					}
				}
	 
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			String strArr[]=hm.get("parentId").split("-");
			LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(0,hm.get("name"),hm.get("description"),
					Float.parseFloat(hm.get("price")),Integer.parseInt(hm.get("stock")),
					Integer.parseInt(strArr[1]),Integer.parseInt(strArr[0]),fm);
			IMONKEY_PRODUCTDao.insert(p);

			response.sendRedirect("admin_productselect");
	}

}
