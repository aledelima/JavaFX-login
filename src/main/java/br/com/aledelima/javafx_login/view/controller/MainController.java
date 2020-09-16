package br.com.aledelima.javafx_login.view.controller;

import br.com.aledelima.javafx_login.model.entities.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	
	private Login currentLogin;

	@FXML
	Label lblMain;
	
	public void setLogin(Login login) {
		this.currentLogin = login;
	}
	
}
