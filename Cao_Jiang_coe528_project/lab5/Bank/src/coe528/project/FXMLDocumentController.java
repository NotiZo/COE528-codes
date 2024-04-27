/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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

/**
 *
 * @author notiz
 */
public class FXMLDocumentController implements Initializable {	
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label wrongLogin;
    @FXML
    private Button button;
    @FXML
    TextField username;
    @FXML
    private PasswordField password;
    
    @FXML
    private void UserLogin(ActionEvent event) throws IOException{
        String user = username.getText();
        String pass = password.getText();

        if (user.equals("admin") && pass.equals("admin")) {
        Bank bank = new Bank();
        bank.changeScene("ManagerMenu.fxml");
    } else {
        try {
            Customer customer = new Customer(user, pass);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
                Parent pane = loader.load();
                CustomerMenuController customerMenuController = loader.getController();
                customerMenuController.setCustomer(customer);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(pane));
                stage.show();
        } catch (FileNotFoundException e) {
            wrongLogin.setText("Invalid username or password");
            return;
        }
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
