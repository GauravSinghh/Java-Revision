package com.masai;

import java.util.Scanner;

public class LibraryInterfaceDemo {

	private static Scanner sc = new Scanner(System.in);

	public static void registration(int age) {

		LibraryUsers lib;
		
		
		String type;
		if (age > 12) {
			lib = new AdultUsers();
			
			((AdultUsers) lib).setAge(age);

			lib.registerAccount();

			
			System.out.println("Enter Book Type you want: ");
			
			type = sc.next();
			
			((AdultUsers) lib).setBookType(type);

			lib.requestBook();
		} 
		else {
			lib = new KidUsers();
			
			
			((KidUsers) lib).setAge(age);

			
			lib.registerAccount();

			System.out.println("Enter Book Type you want: ");
			
			type = sc.next();
			
			((KidUsers) lib).setBookType(type);
			
			lib.requestBook();
		}

	}

	public static void main(String[] args) {

		System.out.println("Welcome to library..");

		System.out.println("Enter your age for register:- ");

		int age = sc.nextInt();
		
		LibraryInterfaceDemo.registration(age);

	}

}
