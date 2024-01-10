package com.tka.level4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	public static void write() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the file name with location path ");
			String path=sc.nextLine();
			FileOutputStream fos=new FileOutputStream(path, true);
			System.out.println("Enter the content you want to enter:");
			String content=sc.nextLine();
			byte b[]=content.getBytes();
			fos.write(b);
			fos.close();
			System.out.println("File is saved at given locaton path");
			
		} catch (Exception e) {
			System.out.println("Some exception found");
			e.printStackTrace();
		}
		
	}
	public static void read() {
		FileInputStream fis=null;
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the file name with location path ");
			String path=sc.nextLine();
			File file=new File(path);
			fis=new FileInputStream(file);
			System.out.println("File content is:");
			int a=0;
			while((a=fis.read())!=-1) {
				System.out.print((char)a);
			}
			
			
		} catch (Exception e) {
			System.out.println("some exception found");
			e.printStackTrace();
			
		}
		finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) {
	write();
	read();

}
}
