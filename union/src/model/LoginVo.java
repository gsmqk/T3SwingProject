package model;

import view.Login;

public class LoginVo {

	public String id;

	public LoginVo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(Login login) {
		this.id = login.idTxt.getText();
	}

}