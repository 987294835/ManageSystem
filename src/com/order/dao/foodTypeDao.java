package com.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.order.bean.dish;
import com.order.bean.dishType;
import com.order.utils.JdbcUtil;
import com.order.utils.PageController;

public class foodTypeDao {
	//查看所有的数据
	
	
	//分页
	//获得总的记录数
	public int getTotalRows(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		int totalRows = 0;
		try {
			conn = JdbcUtil.getConnection();
					//创建statement
			stm = conn.createStatement();
			//发送SQL语句
			String sql = "select count(*) total_rows from tb_dishtype";
			rs = stm.executeQuery(sql);
			//处理结果集
			if (rs.next()) {
				totalRows = rs.getInt("total_rows");
			}
			//释放资源
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, stm, conn);
			
		}
		return totalRows;
	}
	
	public List<dishType> findDishType(){
		List<dishType> dts = new ArrayList<dishType>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//发送SQL语句
			String sql = "select * from tb_dishtype";
			//创建statement
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//处理结果集
			while (rs.next()) {
				dishType dishType = new dishType(rs.getInt("dishType"),rs.getString("typeName"));
				dts.add(dishType);
			}

			//释放资源
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, ps, conn);
			
		}
		return dts;
	}
	
	public List<dishType> findDishType(PageController pc){
		List<dishType> dts = new ArrayList<dishType>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//发送SQL语句
			String sql = "select * from tb_dishtype limit ?,?";
			//创建statement
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pc.getPageStartRow());
			ps.setInt(2, pc.getPageSize());
			rs = ps.executeQuery();
			//处理结果集
			while (rs.next()) {
				dishType dishType = new dishType(rs.getInt("dishType"),rs.getString("typeName"));
				dts.add(dishType);
			}

			//释放资源
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, ps, conn);
			
		}
		return dts;
	}
	
	/*
	 * 增加菜系类
	 */
	public void add(dishType dishtype)
	{
		/*
		 * 连接数据库
		 */
		Connection conn = null;
		Statement stm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn=JdbcUtil.getConnection();
			String sql="insert into tb_dishtype(typeName) values (?)";   //发送sql语句
			ps=conn.prepareStatement(sql);
			ps.setString(1, dishtype.getTypeName());
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, ps, conn); //关闭数据库服务
		}
	}
	
	/*
	 * 修改菜系类
	 */
	public void update(dishType dishtype)
	{
		/*
		 * 连接数据库
		 */
		Connection conn = null;
		Statement stm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn=JdbcUtil.getConnection();
			String name=dishtype.getTypeName();
			int id=dishtype.getDishType();
			String sql="update tb_dishtype set typeName='"+name+"' where dishType='"+id+"'";   //发送sql语句
			stm=conn.createStatement();
			stm.executeUpdate(sql);
			
			
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, ps, conn); //关闭数据库服务
		}
	}
	
	/*
	 * 菜系删除类
	 */
	public void delete(dishType dishtype)
	{
		/*
		 * 连接数据库
		 */
		Connection conn = null;
		Statement stm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn=JdbcUtil.getConnection();
			int id=dishtype.getDishType();
			String sql="delete from tb_dishtype where dishType='"+id+"'";   //发送sql语句
			stm=conn.createStatement();
			stm.executeUpdate(sql);
				
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, ps, conn); //关闭数据库服务
		}
		
	}
}
