package br.com.aledelima.javafx_login.view.controller;

import br.com.aledelima.javafx_login.view.controller.MainController;
import br.com.aledelima.javafx_login.model.entities.User;
import br.com.aledelima.javafx_login.services.UserService;
import br.com.aledelima.javafx_login.App;
import br.com.aledelima.javafx_login.model.entities.Login;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFXMLController implements Initializable { 
    
    @FXML
    private Label lblAlert;
    
    @FXML
    private Label lblUser;
    
    @FXML
    private Label lblPassword;   
    
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnOk;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private void btnOkAction(ActionEvent event) {
        if (!txtUser.getText().equals("")) { //Username filled
            if (!txtPassword.getText().equals("")) { //Password filled?
                UserService userService = new UserService();
                User u = userService.findByName(txtUser.getText());
                if (u == null) { //User does not exist?
                    lblAlert.setText("Non-existent user!");
                } else {
                    if (txtPassword.getText().equals(u.getPassword())) { //Correct password?
                        lblAlert.setText("Welcome, " + u.getName() + "!"); //Welcome
                        Login log = new Login(null, u, LocalDateTime.now(), null);
//                        LoginService loginService = new LoginService();
                       
                        try {
                            //Load and show new window
                            FXMLLoader loader = new FXMLLoader(App.class.getResource("/br/com/aledelima/javafx_login/view/Main.fxml"));
                            Parent root = loader.load();              
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setTitle("Main Screen");
                            stage.setScene(scene);
                            stage.show();
                            //Close login window
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                            //Initialize variables in the new form
                            MainController controller = loader.getController();
                            controller.setLogin(log);
                            controller.lblMain.setText("user '" + log.getUser().getName() + "' logged since " + log.getLogin());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        lblAlert.setText("Invalid password!"); //Password not valid
                        txtPassword.requestFocus();
                        txtPassword.selectAll();
                    }
                }       
            } else {
                lblAlert.setText("Please, fill up the password field!");
                txtPassword.requestFocus();
                txtPassword.selectAll(); 
            }
        } else {
            lblAlert.setText("Please, enter with the user name!");
            txtUser.requestFocus();
            txtUser.selectAll();
        }
    }
     
    @FXML
    private void btnCancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
}
