package demo;

import java.util.Scanner;

import utilities.Borrower;

public class TransactionDemo {
	Scanner sc=new Scanner(System.in);
	public void demo(Borrower borrower)
	{
		while(true)
		{
			System.out.println("Enter Choice\n1.Add Transaction\n2.View Transaction History\n3.Exit");
			int transactionChoice=sc.nextInt();
			if(transactionChoice==1)
			{
				System.out.println("Enter Transaction Type\n1.Lending\n2.Repayment");
				int transactionType=sc.nextInt();
				int amount=0;
				switch(transactionType)
				{
				case 1:
					System.out.println("Amount Lended: ");
					amount=sc.nextInt();
					borrower.lendingTransaction(amount);
					break;
				case 2:
					System.out.println("Amount Repayed: ");
					amount=sc.nextInt();
					borrower.repaymentTransaction(amount);
					break;
				default:
					System.out.println("Invalid Transaction Type");
				}
			}
			else if(transactionChoice==2)
			{
				borrower.printTransactionHistory();
			}
			else
				return;
		}
	}

}
