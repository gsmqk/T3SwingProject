package model;

import view.LoginTest;

public class LoginVo {

	public String id;

	public LoginVo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(LoginTest login) {
		this.id = login.idTxt.getText();
	}

}