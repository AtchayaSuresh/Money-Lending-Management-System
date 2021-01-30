package utilities;


import java.util.ArrayList;

import model.TransactionDetail;

public class Borrower {
	private String borrowerId;
	private String borrowerName;
	private double balance;
	private  ArrayList<TransactionDetail>transaction=new ArrayList<>();
	
	public Borrower(String borrowerId,String borrowerName)
	{
		this.borrowerId=borrowerId;
		this.borrowerName=borrowerName;
		this.balance=0;
	}
	
	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getborrowerName() {
		return borrowerName;
	}

	public void setborrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public ArrayList<TransactionDetail> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<TransactionDetail> transaction) {
		this.transaction = transaction;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void lendingTransaction(int amount)
	{
		TransactionDetail transaction=new TransactionDetail("Lending");
		transaction.setLoanAmount(amount);
		this.setBalance(amount+this.getBalance());
		this.transaction.add(transaction);
	}
	
	public void repaymentTransaction(int amount)
	{
		TransactionDetail transaction=new TransactionDetail("Repayment");
		transaction.setRepaymentAmount(amount);
		double balance=this.balance;
		
		if(balance<amount)
		{
			System.out.println("Amount to be repayed is more than amount to be paid");
			System.out.printf("Amount to be paid: %d\n"
					+ "Amount now repayed: %d",balance,amount);
			return;
		}
		else if(balance==amount)
			System.out.println("Amount fully repayed");
		this.setBalance(balance-amount);
		this.transaction.add(transaction);
	}

	public void printTransactionHistory()
	{
		int index=0;
		if(this.transaction.size()==0)
			System.out.println("No Transactions made");
		else 
		{
			System.out.println("Transaction Number  Transaction Type  Amount Borrowed  "
					+ "Amount Repayed  Balance Amount to be Repayed ");
			for(TransactionDetail transaction:this.transaction)
			{
				System.out.println(index+"  "+transaction.getTransactionType()+"  "+
			transaction.getLoanAmount()+"  "+transaction.getRepaymentAmount()
			+"  "+this.getBalance());
				index++;
			}
		}
	}
}
