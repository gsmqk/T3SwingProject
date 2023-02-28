package model;

public class ExpenseChart_DTO {

	private String month;
	private double expense_amount;
	
	
	public ExpenseChart_DTO(String month, double expense_amount) {
		this.month = month;
		this.expense_amount = expense_amount;
	}

	public ExpenseChart_DTO(){
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	
}