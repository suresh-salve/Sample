package com.tka.level2;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class OnlineShoppigCart implements ShoppingCart {
	static Scanner sc=new Scanner(System.in);
	static List<OnlineShoppigCart> list=new ArrayList<>();
	String name;
	int price;
	String category;
	
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

	public OnlineShoppigCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlineShoppigCart(String name, int price, String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public void add() {
		System.out.println("Enter the  number of product you want to add ");
		int ch=sc.nextInt();
		for (int i=0;i<ch;i++) {

		System.out.println("Enter the name,price,category of product");
		OnlineShoppigCart os=new OnlineShoppigCart(sc.next(),sc.nextInt(),sc.next());
		list.add(os);
		}
		System.out.println(list);
		
	}

	@Override
	public void remove() {
		System.out.println("Enter the name of product you want to remove");
		String proName=sc.next();
		for(int i=0;i<list.size();i++) {
			OnlineShoppigCart os=list.get(i);
			if(proName.equals(os.getName())) {
				list.remove(os);
			}
			
		}
		/*for (OnlineShoppigCart os : list) {
			OnlineShoppigCart os1=os;
			String s=os1.getName();
			if(proName.equals(s)) {
				list.remove(os1);
				}
		
		}*/
		System.out.println("done");
	}
	public void display() {
		System.out.println(list);
	}

	@Override
	public void calculateTotalCost() {
		System.out.println("Which product you want to buy");
		String proNm=sc.next();
		System.out.println("Enter the quantity you want to buy");
		int quantity=sc.nextInt();
		for(int i=0;i<list.size();i++) {
			OnlineShoppigCart os=list.get(i);
			if(proNm.equals(os.getName())) {
				int price=os.getPrice();
				int totalAmount=price*quantity;
				System.out.println("Total bill:"+totalAmount);
				}
			}
		}

	@Override
	public String toString() {
		return "OnlineShoppigCart [name=" + name + ", price=" + price + ", category=" + category + "]";
	}

}
