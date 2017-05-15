package com.order.bean;

import java.util.Date;
/*
 * 菜品类
 */
public class dish {
    private int id; //菜品编号	
    private String dishName; //菜品名称
    private float price;  //菜品价格
    private String dishdesc; //菜品介绍
    private String typeName;  //菜品菜系
    private float Vprice;  //会员价
    /*
     * 构建方法
     */
    public dish() {
		// TODO Auto-generated constructor stub
	}
	public dish(int id,String dishName,float price,String dishdesc,String typeName,float Vprice)
	{
		super();
		this.id=id;
		this.dishName=dishName;
		this.price=price;
		this.dishdesc=dishdesc;
		this.typeName=typeName;
		this.Vprice=Vprice;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDishdesc() {
		return dishdesc;
	}
	public void setDishdesc(String dishesc) {
		this.dishdesc = dishesc;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public float getVprice() {
		return Vprice;
	}
	public void setVprice(float Vprice) {
		this.Vprice = Vprice;
	}
    
}
