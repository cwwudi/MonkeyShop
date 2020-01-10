package com.imonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imonkey.dao.Basedao;

import com.imonkey.entity.LMONKEY_PRODUCT;

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

}
