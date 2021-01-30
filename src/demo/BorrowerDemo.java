package demo;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import utilities.Borrower;
import utilities.Lender;

public class BorrowerDemo {

	public void demo(Lender lender,HashMap<String,String> loginDetails) {
		
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int borrowerChoice;
		while(true) {
			System.out.println("Enter Choice\n1.Create Borrower Account\n2.View Borrowers Details"
					+ "\n3.Delete Borrower Account\n4.View Transaction Details\n5.Exit");
			
			borrowerChoice=sc.nextInt();
			String borrowerId;
			
			switch(borrowerChoice)
			{
				case 1:
					System.out.println("Enter Borrower Details\nEnter BorrowerName: ");
					String borrowerName=sc.next();
					int borrowerIntId=rand.nextInt(100000);
					borrowerId = String.format("%05d", borrowerIntId); 
					
					while(loginDetails.containsKey(borrowerId))
					{
						borrowerIntId=rand.nextInt(100000);
						borrowerId = String.format("%05d",borrowerIntId); 
					}
					lender.createBorrower(borrowerId,borrowerName);
					System.out.println("Borrower created successfully. The Borrower"
							+ "id is "+borrowerId);
					break;
				case 2:
					lender.printBorrower();
					break;
				case 3:
					borrowerId=sc.next();
					if(lender.deleteBorrower(borrowerId))
						System.out.println("Borrower deleted successfully");
					else
						System.out.println("Borrower not found");
					break;
				case 4:
					System.out.println("Enter Borrower ID: ");
					
					HashMap<String, Borrower> borrowerList = lender.getBorrowerList();
					
					borrowerId=sc.next();
					
					if(borrowerList.size()==0||!borrowerList.containsKey(borrowerId))
					{	System.out.println("Borrower not available");
						break;
					}
					
					TransactionDemo transaction=new TransactionDemo();
					Borrower borrower=borrowerList.get(borrowerId);
					transaction.demo(borrower);
					break;
				case 5:
					sc.close();
					return;
			}
		}
		

	}

}
