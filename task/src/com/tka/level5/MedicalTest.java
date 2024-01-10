package com.tka.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalTest extends Exception {
	MedicalTest(){
		super("Invalid data,All coloums must be filled");
	}
	MedicalTest(String message){
		super(message);
	}
	static Scanner sc=new Scanner(System.in);
	static List<Medical> list=new ArrayList<>();
	public static void add() {
		System.out.println("Enter how many patient record you want to add");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter patient id,name,disease,city");
			Medical m=new Medical(sc.nextInt(),sc.next(),sc.next(),sc.next());
			list.add(m);
			System.out.println(list);
		}
	}
	public static void display() {
		System.out.println(list);
	}
	public static void check() {
		try {
			
			for(int i=0;i<1;i++) {
				System.out.println("Enter patient id,name,disease,city");
				Medical m=new Medical(1,"j","g",null);
				if(m.getPatientId()==null||m.getPatientId()==0) {
					throw new MedicalTest();
				}
				 else if(m.getPatientname()==null||m.getPatientname().trim().length()<0) {
					throw new MedicalTest();
				}
				else if(m.getPatientDisease()==null||m.getPatientDisease().trim().length()<0) {
					throw new MedicalTest();
				}
				else if(m.getPatientCity()==null||m.getPatientCity().trim().length()<0) {
					throw new MedicalTest();
				}
				else {
					list.add(m);
				}
			}
			
			} catch (MedicalTest e) {
			e.printStackTrace();
		}
	
	}
public static void main(String[] args) {
	check();
	display();
}
}
