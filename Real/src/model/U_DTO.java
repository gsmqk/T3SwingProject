package model;

public class U_DTO {
	// Fields
	private String u_id;
	private String u_name;
	private String u_password;
	private String u_prePassword;
	private String u_email;
	private String u_grade;
	private String u_status;
	
	// Constructor
	public U_DTO() {}
	public U_DTO(String u_id, String u_name, String u_password, String u_email, String u_grade, String u_status) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_email = u_email;
		this.u_grade = u_grade;
		this.u_status = u_status;
	}
	
	public U_DTO(String u_id, String u_name, String u_password, String u_prePassword, String u_email) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_prePassword = u_prePassword;
		this.u_email = u_email;
	}
	public U_DTO(String u_id, String u_name, String u_password, String u_email) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_email = u_email;
	}
	// Getter / Setter
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_grade() {
		return u_grade;
	}
	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}
	public String getU_status() {
		return u_status;
	}
	public void setU_status(String u_status) {
		this.u_status = u_status;
	}
	
	// to_String
	@Override
	public String toString() {
		return "U_DTO [u_id=" + u_id + ", u_name=" + u_name + ", u_password=" + u_password + ", u_email=" + u_email
				+ ", u_grade=" + u_grade + ", u_status=" + u_status + "]";
	}
	
	
}
