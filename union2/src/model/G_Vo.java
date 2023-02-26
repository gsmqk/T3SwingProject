package model;

public class G_Vo {

	 private String large_id;
	 private String large_classific;
	 private String medium_id;
	 private String medium_classific;
	 private String small_id;
	 private String small_classific;

	 
	 public G_Vo(String large_id, String large_classific, String medium_id, String medium_classific, String small_id,
			String small_classific) {
		this.large_id = large_id;
		this.large_classific = large_classific;
		this.medium_id = medium_id;
		this.medium_classific = medium_classific;
		this.small_id = small_id;
		this.small_classific = small_classific;
	 }
	G_Vo(){	 }
	
	public String getLarge_id() {
		return large_id;
	}
	public void setLarge_id(String large_id) {
		this.large_id = large_id;
	}
	public String getLarge_classific() {
		return large_classific;
	}
	public void setLarge_classific(String large_classific) {
		this.large_classific = large_classific;
	}
	public String getMedium_id() {
		return medium_id;
	}
	public void setMedium_id(String medium_id) {
		this.medium_id = medium_id;
	}
	public String getMedium_classific() {
		return medium_classific;
	}
	public void setMedium_classific(String medium_classific) {
		this.medium_classific = medium_classific;
	}
	public String getSmall_id() {
		return small_id;
	}
	public void setSmall_id(String small_id) {
		this.small_id = small_id;
	}
	public String getSmall_classific() {
		return small_classific;
	}
	public void setSmall_classific(String small_classific) {
		this.small_classific = small_classific;
	}
	
	@Override
	public String toString() {
		return "G_Vo [large_id=" + large_id + ", large_classific=" + large_classific + ", medium_id=" + medium_id
				+ ", medium_classific=" + medium_classific + ", small_id=" + small_id + ", small_classific="
				+ small_classific + "]";
	}
	
}
