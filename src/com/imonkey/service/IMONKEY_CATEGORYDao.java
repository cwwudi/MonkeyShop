package com.imonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imonkey.dao.Basedao;
import com.imonkey.entity.LMONKEY_CATEGORY;
import com.imonkey.entity.LMONKEY_USER;


public class IMONKEY_CATEGORYDao {
	public static ArrayList<LMONKEY_CATEGORY> selectAll(){
		ArrayList<LMONKEY_CATEGORY> list=new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		try {
			 
			
			
			 String sql="SELECT * from imonkey_category";
			 ps=conn.prepareStatement(sql);	
			 rs=ps.executeQuery();
			while(rs.next()){
				LMONKEY_CATEGORY category=new LMONKEY_CATEGORY(rs.getInt(1),rs.getString(2),rs.getInt(3));
				list.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
	}

	public static int insert(String cateName,String parentId){
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="insert into imonkey_category( CATE_NAME,CATE_PARENT_ID) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cateName);
			ps.setString(2, parentId);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		
		
		
		
		return count;
	}

	public static LMONKEY_CATEGORY selectByid(String id){
		LMONKEY_CATEGORY c=null;
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="select * from  imonkey_category where CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				c=new LMONKEY_CATEGORY(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return c;
	}

	public static int updateCateById(LMONKEY_CATEGORY category){
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		int count=0;
		try {
			String sql="UPDATE imonkey_category set CATE_NAME=?,CATE_PARENT_ID=? WHERE CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCATE_NAME());
			ps.setInt(2, category.getCATE_PARENT_ID());
			ps.setInt(3, category.getCATE_ID());
			
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		return count;
	}

	public static int deleteCateById(int id){
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="delete from imonkey_category where CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		
		
		
		return count;
	}

	public static ArrayList<LMONKEY_CATEGORY> selectCat(String flag){
		ArrayList<LMONKEY_CATEGORY> list=new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		try {
			String sql=null;
			if(flag!=null && flag.equals("father")){
				sql="SELECT * from imonkey_category where CATE_PARENT_ID=0";
			}else{
				sql="SELECT * from imonkey_category where CATE_PARENT_ID!=0";
			}
			
			
			
			 ps=conn.prepareStatement(sql);	
			 
			 rs=ps.executeQuery();
			while(rs.next()){
				LMONKEY_CATEGORY category=new LMONKEY_CATEGORY(rs.getInt(1),rs.getString(2),rs.getInt(3));
				list.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
	}
}
