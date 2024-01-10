package com.tka.level3;

public class RetailShop {
String name;
int price;
String category;
public RetailShop() {
	super();
	// TODO Auto-generated constructor stub
}
public RetailShop(String name, int price, String category) {
	super();
	this.name = name;
	this.price = price;
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "RetailShop [name=" + name + ", price=" + price + ", category=" + category + "]";
}

}
