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

public class MFoodDao {
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
			String sql = "select count(*) total_rows from tb_dish";
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
	
	public List<dish> findDish(PageController pc){
		List<dish> dts = new ArrayList<dish>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//发送SQL语句
			String sql = "select * from tb_dish limit ?,?";
			//创建statement
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pc.getPageStartRow());
			ps.setInt(2, pc.getPageSize());
			rs = ps.executeQuery();
			//处理结果集
			while (rs.next()) {
				dish dish = new dish(rs.getInt("id"),rs.getString("dishName"),rs.getFloat("price"),rs.getString("dishdesc"),rs.getString("typeName"),rs.getFloat("Vprice"));
				dts.add(dish);
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
	 * 菜品删除类
	 */
	public void delete(dish dish)
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
			int id=dish.getId();
			String sql="delete from tb_dish where id='"+id+"'";   //发送sql语句
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
	 * 增加菜系类
	 */
	public void add(dish dish)
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
			String sql="insert into tb_dish(dishName,price,dishdesc,typeName,Vprice) values (?,?,?,?,?)";   //发送sql语句
			ps=conn.prepareStatement(sql);
			ps.setString(1,dish.getDishName());
			ps.setFloat(2,dish.getPrice());
			ps.setString(3,dish.getDishdesc());
			ps.setString(4,dish.getTypeName());
			ps.setFloat(5,dish.getVprice());
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
	 * 修改菜品类
	 */
	public void update(dish dish)
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
			String tname=dish.getTypeName();//获取菜系名
			String fname=dish.getDishName();//获取菜品名
			int id=dish.getId();//获取菜品id
			float price=dish.getPrice();//获取价格
			float vprice=dish.getVprice();//获取会员价格
			String dishdesc=dish.getDishdesc();//获取简介
			String sql="update tb_dish set dishName='"+fname+"',price='"+price+"',Vprice='"+vprice+"',typeName='"+tname+"',dishdesc='"+dishdesc+"' where id='"+id+"' ";   //发送sql语句
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
