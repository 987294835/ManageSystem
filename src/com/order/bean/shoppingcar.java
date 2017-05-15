package com.order.bean;

public class shoppingcar {
	private int orderId; //客户id
	private int id;      //菜品id
	private String dishName;
	private float price;
	private int dishType;
	private String dishesc;
	private int number;
	public shoppingcar()
	{	
	}
	public shoppingcar(int orderId,int id,String dishName,int dishType,String dishesc,int number)
	{
		this.orderId=orderId;
		this.id=id;
		this.dishName=dishName;
		this.dishType=dishType;
		this.dishesc=dishesc;
		this.number=number;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getDishType() {
		return dishType;
	}
	public void setDishType(int dishType) {
		this.dishType = dishType;
	}
	public String getDishesc() {
		return dishesc;
	}
	public void setDishesc(String dishesc) {
		this.dishesc = dishesc;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
