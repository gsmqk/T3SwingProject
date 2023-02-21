package comtroller;

public class UserVo {
	private String userid;
	private String username;
	private String userpassword;
	private String useremail;
	private String usergrade;
	private String userstatus;
	
	public UserVo() {}
	public UserVo(String userid, String username, String userpassword, String useremail, String usergrade,
			String userstatus) {	
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.useremail = useremail;
		this.usergrade = usergrade;
		this.userstatus = userstatus;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(String usergrade) {
		this.usergrade = usergrade;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + ", useremail="
				+ useremail + ", usergrade=" + usergrade + ", userstatus=" + userstatus + "]";
	}
	

}
