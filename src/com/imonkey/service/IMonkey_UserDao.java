package com.imonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imonkey.dao.Basedao;
import com.imonkey.entity.LMONKEY_USER;



public class IMonkey_UserDao {
	public static int insert(LMONKEY_USER u){
		String sql="INSERT INTO imonkey_user VALUES(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params={u.getUSER_ID(),u.getUSER_NAME(),u.getUSER_PASSWORD(),u.getUSER_SEX(),u.getUSER_BIRHFDAY(),
				u.getUSER_IDENITY_CODE(),u.getUSER_EAMIL(),u.getUSER_MOBILE(),u.getUSER_ADDRESS(),u.getUSER_STATUES()};
		return Basedao.exectuIUD(sql, params);
	}
	//
	public static int[] totalPage(int count,String keywords ){
		int[] arr={0,1};
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			String sql=null;
			if(keywords!=null){
				sql="select count(*) from imonkey_user where USER_NAME like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keywords+"%");
			}else{
				sql="select count(*) from imonkey_user";
				ps=conn.prepareStatement(sql);
			}
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				arr[0]=rs.getInt(1);
				if(arr[0]%count==0){
				arr[1]=arr[0]/count;
			}else{
				arr[1]=arr[0]/count+1;
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
	}
	
	/**
	 * @param id
	 * @return
	 * 通过id查找用户
	 */
	public static LMONKEY_USER selectByid(String id){
		LMONKEY_USER u=null;
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="select * from imonkey_user where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new LMONKEY_USER(rs.getString("USER_ID"),rs.getString("USER_NAME"),rs.getString("USER_PASSWORD"),rs.getString("USER_SEX"),
						rs.getString("USER_BIRHFDAY"),rs.getString("USER_IDENITY_CODE"),rs.getString("USER_EAMIL"),rs.getString("USER_MOBILE"),rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUES"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	
	/**
	 * 根据id更新用户
	 */
	public static int updaateUserById(LMONKEY_USER user){
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		int count=0;
		try {
			String sql="UPDATE imonkey_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRHFDAY=?,USER_EAMIL=?,USER_MOBILE=?,USER_ADDRESS=?  where USER_ID=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUSER_NAME());
			ps.setString(2, user.getUSER_PASSWORD());
			ps.setString(3, user.getUSER_SEX());
			ps.setString(4, user.getUSER_BIRHFDAY());
			ps.setString(5, user.getUSER_EAMIL());
			ps.setString(6, user.getUSER_MOBILE());
			ps.setString(7, user.getUSER_ADDRESS());
			ps.setString(8, user.getUSER_ID());
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		return count;
	}
	/**
	 * @param id
	 * @return
	 * 根据id删除用户
	 */
	public static int selectByNM(String userid,String password){
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="select count(*) from imonkey_user where USER_ID=? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return count;
	}
	/**
	 * @param id
	 * @return
	 * 根据id删除用户
	 */
	public static int deleteUserById(String id){
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		
		try {
			String sql="delete from imonkey_user where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
		}
		
		
		
		return count;
	}
	
	/**
	 * @param cpage
	 * @param count
	 * @param keywords
	 * @return
	 * 根据条件查找所有用户
	 */
	public static ArrayList<LMONKEY_USER> selectAll(int cpage,int count,String keywords){
		
		
				
		ArrayList<LMONKEY_USER> list=new ArrayList<LMONKEY_USER>();
		ResultSet rs=null;
		Connection conn= Basedao.getconn();
		PreparedStatement ps=null;
		try {
			String sql=null;
			
			if(keywords!=null){
				sql="SELECT * from imonkey_user where USER_NAME like ? order by USER_BIRHFDAY desc limit ?,? " ;
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keywords+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}else{
				sql="SELECT * from imonkey_user order by USER_BIRHFDAY desc limit ?,? " ;
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
			
			
			rs=ps.executeQuery();
			while(rs.next()){
				LMONKEY_USER user=new LMONKEY_USER(rs.getString("USER_ID"),rs.getString("USER_NAME"),rs.getString("USER_PASSWORD"),rs.getString("USER_SEX"),
						rs.getString("USER_BIRHFDAY"),rs.getString("USER_IDENITY_CODE"),rs.getString("USER_EAMIL"),rs.getString("USER_MOBILE"),rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUES"));
				list.add(user);
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
