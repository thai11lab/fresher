package model;

import java.util.Scanner;

import utils.ValidateData;

public class Student {
	ValidateData validateData = new ValidateData();
	private Long id;
	private String name;
	private String adrress;
	private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(Long id, String name, String adrress, String email) {
		this.id = id;
		this.name = name;
		this.adrress = adrress;
		this.email = email;
	}
	public Student() {
		
	}
	public Student(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public void inTT() {
		System.out.println("\t\tStudent id : "+this.id);
		System.out.println("\t\tStudent name : "+this.name);
		System.out.println("\t\tEmail : "+this.email);
		System.out.println("\t\tAddress : "+this.adrress+"\n");
	}
	
	public void nhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input id : ");	
		this.id = sc.nextLong();
		sc.nextLine();
		System.out.print("Input name : ");
		this.name = sc.nextLine();
		System.out.print("Input email : ");
		String email;
		do {
			email = sc.nextLine();
			if(!validateData.checkEmail(email)) {
				System.out.println("Nhập lại đúng định dạng email !");
			}
		}while(!validateData.checkEmail(email));
		this.email=email;
		System.out.print("Input address : ");
		this.adrress = sc.nextLine();
	}
}
