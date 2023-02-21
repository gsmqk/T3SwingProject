package model;

public class F_DTO {
	// Fields
	private String F_name;
	private String F_major;
	private String F_minor;
	private String F_place;
	private String F_Quantity;
	private String F_unit;
	private String F_price;
	private String F_store;
	private String F_inDate;
	private String F_sobi;
	
	//Constructor
	public F_DTO() {}
	public F_DTO(String f_name, String f_major, String f_minor, String f_place, String f_Quantity, String f_unit,
			String f_price, String f_store, String f_inDate, String f_sobi) {
		F_name = f_name;
		F_major = f_major;
		F_minor = f_minor;
		F_place = f_place;
		F_Quantity = f_Quantity;
		F_unit = f_unit;
		F_price = f_price;
		F_store = f_store;
		F_inDate = f_inDate;
		F_sobi = f_sobi;
	}
	// Getter / Setter
	public String getF_name() {
		return F_name;
	}
	public void setF_name(String f_name) {
		F_name = f_name;
	}
	public String getF_major() {
		return F_major;
	}
	public void setF_major(String f_major) {
		F_major = f_major;
	}
	public String getF_minor() {
		return F_minor;
	}
	public void setF_minor(String f_minor) {
		F_minor = f_minor;
	}
	public String getF_place() {
		return F_place;
	}
	public void setF_place(String f_place) {
		F_place = f_place;
	}
	public String getF_Quantity() {
		return F_Quantity;
	}
	public void setF_Quantity(String f_Quantity) {
		F_Quantity = f_Quantity;
	}
	public String getF_unit() {
		return F_unit;
	}
	public void setF_unit(String f_unit) {
		F_unit = f_unit;
	}
	public String getF_price() {
		return F_price;
	}
	public void setF_price(String f_price) {
		F_price = f_price;
	}
	public String getF_store() {
		return F_store;
	}
	public void setF_store(String f_store) {
		F_store = f_store;
	}
	public String getF_inDate() {
		return F_inDate;
	}
	public void setF_inDate(String f_inDate) {
		F_inDate = f_inDate;
	}
	public String getF_sobi() {
		return F_sobi;
	}
	public void setF_sobi(String f_sobi) {
		F_sobi = f_sobi;
	}
	
	// toString
	@Override
	public String toString() {
		return "F_DTO [F_name=" + F_name + ", F_major=" + F_major + ", F_minor=" + F_minor + ", F_place=" + F_place
				+ ", F_Quantity=" + F_Quantity + ", F_unit=" + F_unit + ", F_price=" + F_price + ", F_store=" + F_store
				+ ", F_inDate=" + F_inDate + ", F_sobi=" + F_sobi + "]";
	}	
	
	
}
