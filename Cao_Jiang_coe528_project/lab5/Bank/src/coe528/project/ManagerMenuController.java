/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author notiz
 */
public class ManagerMenuController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label nouser;
    @FXML
    private TextField adduser;
    @FXML
    private TextField deleteuser;
    @FXML
    private TextField adduserpassword;
    @FXML
    private Button addbutton;
    @FXML
    private Button deletebutton;
    @FXML
    private Button logout;
    private Manager manager;
    
    public ManagerMenuController(){
        manager = new Manager("admin", "admin");
    }
    
    @FXML
    public void  Addbutton(){
         String username = adduser.getText();
    String password = adduserpassword.getText();
    if (manager.addCustomer(username, password)) {
        nouser.setText("Customer added successfully.");
    } else {
        nouser.setText("Failed to add customer.");
    }
    }
    
    @FXML
    public void Deletebutton(){
        String username = deleteuser.getText();
        String password = "";
        if (manager.deleteCustomer(username, password)) {
        nouser.setText("Customer deleted successfully.");
    } else {
        nouser.setText("Failed to delete customer.");
    }
    }
    
    @FXML
    public void LogoutButton() throws IOException{
        manager.logout();
        Bank bank=new Bank();
        bank.changeScene("FXMLDocument.fxml");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
