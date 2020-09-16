package br.com.aledelima.javafx_login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/aledelima/javafx_login/view/LoginFXML.fxml"));
          Parent parent = loader.load();
          Scene mainScene = new Scene(parent);
          primaryStage.setScene(mainScene);
          primaryStage.setTitle("Bar e Restaurante Frei Caneca - Login");
          primaryStage.show();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    public static void main(String[] args) {
        launch();
    }

}