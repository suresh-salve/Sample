package com.tka.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RetailShopTest {
static Scanner sc=new Scanner(System.in);
static List<RetailShop> list=new ArrayList<>();


public static void main(String[] args) {
	int ch;
	do {
	System.out.println("1.Add products");
	System.out.println("2.Display list");
	System.out.println("3.Remove product");
	System.out.println("4.Search product by name");
	System.out.println("5.Search product by category");
	System.out.println("6.Search product by price range");
	int c=sc.nextInt();
	switch (c) {
	case 1:
		System.out.println("Enter how many products you want to add");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Product name,price,category");
			RetailShop rs=new RetailShop(sc.next(),sc.nextInt(),sc.next());
			list.add(rs);
		}
		break;
		
	case 2:
		for (Object retail : list) {
			System.out.println(retail);
		}
		break;
		
	case 3:
		System.out.println("Enter the name of product you want to remove");
		String proName=sc.next();
		for(int i=0;i<list.size();i++) {
			RetailShop rs=list.get(i);
			if(proName.equals(rs.getName())) {
				list.remove(rs);
			}
			
		}
        System.out.println("Product remove succesfully");
		break;
		
		case 4:
			System.out.println("Enter the product name you want to search");
			String productNm=sc.next();
			for (RetailShop retail : list) {
				RetailShop rs=retail;
				if(rs.getName().equals(productNm))
					System.out.println(rs);
			}
					
			break;
			
		case 5:
			System.out.println("Enter the product Category you want to search");
			String productcate=sc.next();
			for (RetailShop retail : list) {
				RetailShop rs=retail;
				if(rs.getCategory().equals(productcate))
					System.out.println(rs);
			}
			break;
			
			
		case 6:
			System.out.println("Enter the the range of price");
			int range1=sc.nextInt();
			int range2=sc.nextInt();
			for (RetailShop retail : list) {
				RetailShop rs=retail;
				if(rs.getPrice()>=range1&&rs.getPrice()<=range2)
					System.out.println(rs);
			}
			break;
	default:
		break;
	}
	System.out.println("Do you want to continue press 1 else press 0");
	ch=sc.nextInt();
}while(ch==1);
}
}