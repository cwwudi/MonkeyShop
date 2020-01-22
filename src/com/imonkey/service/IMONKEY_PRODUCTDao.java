package com.imonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imonkey.dao.Basedao;
import com.imonkey.entity.LMONKEY_PRODUCT;
import com.sun.org.apache.regexp.internal.recompile;

public class IMONKEY_PRODUCTDao {
	/**
	 * @return 查询所有产品，返回列表
	 */
	public static ArrayList<LMONKEY_PRODUCT> selectAll(){
		ArrayList<LMONKEY_PRODUCT> list=new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		try {
			 
			
			
			 String sql="SELECT * from imonkey_product";
			 ps=conn.prepareStatement(sql);	
			 rs=ps.executeQuery();
			while(rs.next()){
				LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
	}

	public static LMONKEY_PRODUCT selectById(int id){
		LMONKEY_PRODUCT p=null;
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="select * from  imonkey_product where PRODUCT_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				p=new LMONKEY_PRODUCT(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return p;
	}

	public static int insert(LMONKEY_PRODUCT p){
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		String sql="insert into imonkey_product values(?,?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p.getPRODUCT_ID());
			ps.setString(2, p.getPRODUCT_NAME());
			ps.setString(3, p.getPRODUCT_DESCRIPTION());
			ps.setFloat(4, p.getPRODUCT_PRICE());
			ps.setFloat(5, p.getPRODUCT_STOCK());
			ps.setInt(6, p.getPRODUCT_FCATE());
			ps.setInt(7, p.getPRODUCT_CCATE());
			ps.setString(8, p.getPRODUCT_FILENAME());
			count =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		
		
		
		
		return count;
	}

	public static int deleteById(int id){
		int count=0;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql = "delete from  imonkey_product where PRODUCT_ID=?";
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


	public static int updateById(LMONKEY_PRODUCT p){
		int count=0;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="update imonkey_product set PRODUCT_NAME=?,PRODUCT_DESCRIPTION=?,PRODUCT_PRICE=?,"
					+ "PRODUCT_STOCK=?,PRODUCT_FCATE=?,PRODUCT_CCATE=?,PRODUCT_FILENAME=? where PRODUCT_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getPRODUCT_NAME());
			ps.setString(2, p.getPRODUCT_DESCRIPTION());
			ps.setFloat(3, p.getPRODUCT_PRICE());
			ps.setInt(4, p.getPRODUCT_STOCK());
			ps.setInt(5, p.getPRODUCT_FCATE());
			ps.setInt(6, p.getPRODUCT_CCATE());
			ps.setString(7, p.getPRODUCT_FILENAME());
			ps.setInt(8, p.getPRODUCT_ID());
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		
		
		
		
		
		return count;
	}
}
