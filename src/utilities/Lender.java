package utilities;

import java.util.HashMap;

public class Lender {
	private String lenderId;
	private String lenderName;
	private HashMap<String,Borrower> borrowerList;
	
	public Lender(String lenderId,String lenderName)
	{
		this.lenderId=lenderId;
		this.lenderName=lenderName;
		this.borrowerList=new HashMap<>();
	}

	public String getLenderName() {
		return lenderName;
	}

	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public HashMap<String,Borrower> getBorrowerList() {
		return borrowerList;
	}

	public void setBorrowerList(HashMap<String,Borrower> borrowerList) {
		this.borrowerList = borrowerList;
	}
	
	public void createBorrower(String borrowerId,String name)
	{
		Borrower borrower=new Borrower(borrowerId,name);
		this.borrowerList.put(borrowerId,borrower);
	}
	public void printBorrower()
	{
		if(this.borrowerList.size()==0) 
		{
			System.out.println("No Borrowers Available");
			return;
		}
		System.out.println("BorrowerId   BorrowerName  Balance To Be Paid");
		for(Borrower borrower:this.borrowerList.values())
		{
			System.out.println(borrower.getBorrowerId()+" "+borrower.getborrowerName()+
					" "+borrower.getBalance());
		}
	}
	
	public boolean deleteBorrower(String borrowerId)
	{
		if(this.borrowerList.containsKey(borrowerId))
		{
			System.out.printf("%s deleted successfully",borrowerId);
			this.borrowerList.remove(borrowerId);
			return true;
		}
		return false;
	}
}
