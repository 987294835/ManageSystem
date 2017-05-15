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
import com.order.bean.table;
import com.order.utils.JdbcUtil;
import com.order.utils.PageController;

public class MBoardDao {
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
			String sql = "select count(*) total_rows from tb_table";
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
	
	public List<table> findTable(){
		List<table> dts = new ArrayList<table>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//发送SQL语句
			String sql = "select * from tb_table";
			//创建statement
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//处理结果集
			while (rs.next()) {
				table table = new table(rs.getInt("table_id"),rs.getString("table_name"),rs.getString("status"),rs.getString("order_client"),rs.getString("date"));
				dts.add(table);
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
	
	public List<table> findTable(PageController pc){
		List<table> dts = new ArrayList<table>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//发送SQL语句
			String sql = "select * from tb_table limit ?,?";
			//创建statement
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pc.getPageStartRow());
			ps.setInt(2, pc.getPageSize());
			rs = ps.executeQuery();
			//处理结果集
			while (rs.next()) {
				table table = new table(rs.getInt("table_id"),rs.getString("table_name"),rs.getString("status"),rs.getString("order_client"),rs.getString("date"));
				dts.add(table);
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
	 * 餐桌删除类
	 */
	public void delete(table table)
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
			int id=table.getTable_id();
			String sql="delete from tb_table where table_id='"+id+"'";   //发送sql语句
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
	 * 增加餐桌类	
	 */
	
	public void add(table table)
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
			String sql="insert into tb_table(table_name,status) values (?,?)";   //发送sql语句
			ps=conn.prepareStatement(sql);
			ps.setString(1,table.getTable_name());
			ps.setString(2,table.getStatus());
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
	 * 修改餐桌类
	 */
	public void update(table table)
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
			String tname=table.getTable_name();//获取餐桌名
			int id=table.getTable_id();//获取餐桌id
			String status=table.getStatus();
			String cname=table.getOrder_client();
			String date=table.getDate();
			String sql="update tb_table set table_name='"+tname+"',status='"+status+"',order_client='"+cname+"',date='"+date+"' where table_id='"+id+"' ";   //发送sql语句
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