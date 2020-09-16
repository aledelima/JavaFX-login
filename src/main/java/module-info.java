module br.com.aledelima.javafx_login {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens br.com.aledelima.javafx_login.view.controller to javafx.fxml;
    exports br.com.aledelima.javafx_login;
    exports br.com.aledelima.javafx_login.view.controller;
}