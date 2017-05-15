package com.order.bean;

import java.sql.Date;

/*
 * 餐桌类
 */
public class table {
	private int table_id;
	private String table_name;
	private String status;
	private String order_client;
	private String date;
	public table(){}
	public table(int table_id,String table_name,String status,String order_client,String date)
	{
		this.table_id=table_id;
		this.status=status;
		this.order_client=order_client;
		this.table_name=table_name;
		this.date=date;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int tableId) {
		table_id = tableId;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrder_client() {
		return order_client;
	}
	public void setOrder_client(String orderClient) {
		order_client = orderClient;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
