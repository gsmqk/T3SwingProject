package model;

public class F_DTO {
	
	// Fields
	private String grocery_id;
	private String grocery_name;
	private String large_classific;
	private String medium_classific;
	private String small_classific;
	private String storage_place;
	private String store_id;
	private String quantity;
	private String unit;
	private String price;
	private String store_name;
	private String input_date;
	private String expire_date;
	private String user_id;
	private String due_date;

	// Constructor
	public F_DTO() {
	}

	public F_DTO(String grocery_id, String grocery_name, String large_classific, String medium_classific,
			String small_classific, String storage_place, String store_id, String quantity, String unit, String price,
			String store_name, String input_date, String expire_date, String user_id) {
		this.grocery_id = grocery_id;
		this.grocery_name = grocery_name;
		this.large_classific = large_classific;
		this.medium_classific = medium_classific;
		this.small_classific = small_classific;
		this.storage_place = storage_place;
		this.store_id = store_id;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.store_name = store_name;
		this.input_date = input_date;
		this.expire_date = expire_date;
		this.user_id = user_id;
	}

	public F_DTO(String gname, String large, String medium, String small, String place, String quantity2, String unit2,
			String price2, String store_name2, String input_date2, String expire_date2, String due_date2) {
		this.grocery_name = gname;
		this.large_classific = large;
		this.medium_classific = medium;
		this.small_classific = small;
		this.storage_place = place;
		this.quantity = quantity2;
		this.unit = unit2;
		this.price = price2;
		this.store_name = store_name2;
		this.input_date = input_date2;
		this.expire_date = expire_date2;
		this.due_date = due_date2;
	}

	// Getter / Setter
	public String getGrocery_id() {
		return grocery_id;
	}

	public void setGrocery_id(String grocery_id) {
		this.grocery_id = grocery_id;
	}

	public String getGrocery_name() {
		return grocery_name;
	}

	public void setGrocery_name(String grocery_name) {
		this.grocery_name = grocery_name;
	}

	public String getLarge_classific() {
		return large_classific;
	}

	public void setLarge_classific(String large_classific) {
		this.large_classific = large_classific;
	}

	public String getMedium_classific() {
		return medium_classific;
	}

	public void setMedium_classific(String medium_classific) {
		this.medium_classific = medium_classific;
	}

	public String getSmall_classific() {
		return small_classific;
	}

	public void setSmall_classific(String small_classific) {
		this.small_classific = small_classific;
	}

	public String getStorage_place() {
		return storage_place;
	}

	public void setStorage_place(String storage_place) {
		this.storage_place = storage_place;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	// toString
	@Override
	public String toString() {
		return "F_DTO [grocery_id=" + grocery_id + ", grocery_name=" + grocery_name + ", large_classific="
				+ large_classific + ", medium_classific=" + medium_classific + ", small_classific=" + small_classific
				+ ", storage_place=" + storage_place + ", store_id=" + store_id + ", quantity=" + quantity + ", unit="
				+ unit + ", price=" + price + ", store_name=" + store_name + ", input_date=" + input_date
				+ ", expire_date=" + expire_date + ", user_id=" + user_id + "]";
	}
	
	
}
