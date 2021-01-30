package demo;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import utilities.Lender;

import businessLogic.RegistrationValidation;
import businessLogic.ValidateUser;

public class MoneyLendingDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		System.out.println("Welcome to Money Lending Management System");
		
		HashMap<String,String> registrationDetails=new HashMap<>();
		HashMap<String,String> loginDetails=new HashMap<>();
		
		HashMap<String,Lender> lenderList=new HashMap<>();
		
		
		int lenderIntId;
		String userName,password,confirmPassword;
		String lenderId;
		
		while(true){
			System.out.println("Enter\n1.Login\n2.SignUp\n3.Exit");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter Login Details\nEnter lenderIntId: ");
				lenderId=sc.next();
				System.out.println("Enter password: ");
				password=sc.next();
				
				ValidateUser validateUser=new ValidateUser();
				
				if(validateUser.validate(lenderId,password,loginDetails))
				{
					System.out.println("Sign In Successful");
					Lender lender=lenderList.get(lenderId);
					BorrowerDemo borrowerDemo=new BorrowerDemo();
					borrowerDemo.demo(lender,loginDetails);
				}
	
			}
			else if(choice==2)
			{
				System.out.println("Enter SignUp Details\nEnter Username: ");
	
				userName=sc.next();
				
				if(registrationDetails.containsKey(userName))
					System.out.println("UserName already exists");
				
				System.out.println("Enter password: ");
				password=sc.next();
				System.out.println("Confirm password: ");
				confirmPassword=sc.next();
				
				RegistrationValidation registerValidate=
						new RegistrationValidation();
				
				if(registerValidate.checkUserDetails(userName, password, confirmPassword))
				{
					
						registrationDetails.put(userName,password);
						
						lenderIntId=rand.nextInt(100000);
						lenderId = String.format("%05d", lenderIntId); 
						
						while(loginDetails.containsKey(lenderId))
						{
							lenderIntId=rand.nextInt(100000);
							lenderId = String.format("%05d", lenderIntId); 
						}
						loginDetails.put(lenderId, password);
						lenderList.put(lenderId,new Lender(lenderId,userName));
						System.out.println("Signup Successful. Your LenderID is "+lenderId);
				}
				
			}
			else if(choice==3)
			{
				sc.close();
				return;
			}
			else
				System.out.println("Invalid Choice");
		}
	}

}
