import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class paymentcontroller {

    @FXML
    private Button balance;

    @FXML
    private Button deposit;

    @FXML
    private Button exitbtn;

    @FXML
    private Label messagebox;

    @FXML
    private Button withdraw;

    int mainBalance = 0;

    @FXML
    void checkBalance(ActionEvent event) throws IOException{
        messagebox.setText("Your Balance: "+mainBalance);
    }

    @FXML
    void depositeMoney(ActionEvent event) throws IOException{
        try {
            String moneystr = "";
            moneystr = JOptionPane.showInputDialog("Enter how much money you want to deposit!");
            int money = Integer.parseInt(moneystr);
            mainBalance = mainBalance + money;
            messagebox.setText(money+" deposit sucessfully!! \n Available Balance : "+mainBalance);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void withdrawMoney(ActionEvent event) throws IOException{
        try {
            String moneystr = "";
            moneystr = JOptionPane.showInputDialog("Enter how much money you want to deposit!");
            int money = Integer.parseInt(moneystr);
            if(money < mainBalance){
                mainBalance = mainBalance - money;
                messagebox.setText(money+" withdraw sucessfully!! \n Available Balance : "+mainBalance);   
            }
            else{
                JOptionPane.showMessageDialog(null, "Balance is low!! plese select less amount..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) throws IOException{
        JOptionPane.showMessageDialog(null, "Thanks for banking with us :)");
        Platform.exit();
    }

}

