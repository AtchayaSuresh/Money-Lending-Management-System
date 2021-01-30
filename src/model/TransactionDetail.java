package model;

import java.time.LocalDate;

public class TransactionDetail{
	private LocalDate date;
	private String transactionType;
	private double loanAmount;
	private double repaymentAmount;
	
	public TransactionDetail(String transactionType)
	{
		this.date=LocalDate.now();
		this.loanAmount=0;
		this.repaymentAmount=0;
		this.transactionType=transactionType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRepaymentAmount() {
		return repaymentAmount;
	}

	public void setRepaymentAmount(double repaymentAmount) {
		this.repaymentAmount = repaymentAmount;
	}

	
}
