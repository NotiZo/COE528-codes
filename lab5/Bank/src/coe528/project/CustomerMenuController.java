/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class CustomerMenuController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Customer customer;
    @FXML
    private Label error;
    @FXML
    private Label balance;
    @FXML
    private Label level;
    @FXML
    private Button deposit;
    @FXML
    private Button withdraw;
    @FXML
    private Button purchase;
    @FXML
    private Button logout;
    @FXML
    private TextField depositamount;
    @FXML
    private TextField withdrawamount;
    @FXML
    private TextField onlinepurchaseamount;
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
        updateLabels();
    }
    @FXML
    public void deposit(ActionEvent event){
        double amount = Double.parseDouble(depositamount.getText());
        if(amount<0){
           error.setText("cant deposit negative number"); 
        }else{
        customer.deposit(amount);
        updateLabels();
        }
    }

    @FXML
    public void withdraw(ActionEvent event){
        double amount = Double.parseDouble(withdrawamount.getText());
        if(amount>customer.getBalance()){
            error.setText("Can't withdraw more than the balance");
        }else{
          customer.withdraw(amount);
          updateLabels();  
        }
    }

    @FXML
    public void purchase(ActionEvent event){
        double amount = Double.parseDouble(onlinepurchaseamount.getText());
        if(amount<50){
            error.setText("Must be purchase of 50 or above");
        }else{
        customer.purchase(amount);
        updateLabels();
        }
    }

    private void updateLabels() {
        balance.setText(String.valueOf(customer.getBalance()));
        level.setText(customer.getLevel().toString());
    }
    
    @FXML
    public void logout(ActionEvent event) throws IOException {
        customer.Logout();
        Bank bank = new Bank();
        bank.changeScene("FXMLDocument.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }

    
}
