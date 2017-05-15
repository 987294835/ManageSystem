package com.order.bean;
/*
 * 菜系类
 */
public class dishType {
    private int dishType;//菜系编号
	private String typeName; //菜系名称
	public dishType() {
		// TODO Auto-generated constructor stub
	}
	public dishType(int dishType,String typeName)
	{
		this.dishType=dishType;
		this.typeName=typeName;
	}
	public int getDishType() {
		return dishType;
	}
	public void setDishType(int dishType) {
		this.dishType = dishType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
