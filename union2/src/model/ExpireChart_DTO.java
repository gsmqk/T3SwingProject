package model;

public class ExpireChart_DTO {
	
	private String month;
	private double expire_amount;
	
	public ExpireChart_DTO(String month, double expire_amount) {
		super();
		this.month = month;
		this.expire_amount = expire_amount;
	}
	public ExpireChart_DTO() {
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getExpire_amount() {
		return expire_amount;
	}
	public void setExpire_amount(double expire_amount) {
		this.expire_amount = expire_amount;
	}
	
}