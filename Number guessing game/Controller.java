import java.util.Random;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button btn;

    @FXML
    private TextField guessednumber;

    @FXML
    private Label msg;

    @FXML
    private Label chanse;

    int totalChances = 10;
    int randomNumber;
    
    public int setRandomnumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(100);
        return randomNumber;
    }

    int randNumber = setRandomnumber();
    @FXML
    void submit(ActionEvent event) {
        try {
            String guessNumberString = guessednumber.getText();
            int guessNumberInt = Integer.parseInt(guessNumberString);
            if(randNumber == guessNumberInt){
                JOptionPane.showMessageDialog(null, "Congratulations!! You WIN :) \n Your score "+totalChances+" out of 10");
                msg.setText("Winner");
                Platform.exit();
            }
            else if (guessNumberInt < randomNumber) {
                totalChances--;
                msg.setText(" Guess more Higher");
                setChancesMessage();
            }
            else if (guessNumberInt > randomNumber) {
                totalChances--;
                msg.setText(" Guess more Lower");
                setChancesMessage();
            }
            if(totalChances <= 0){
                JOptionPane.showMessageDialog(null, "You used your maximum 10 chances!!\n Better luck next time :)");
                Platform.exit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setChancesMessage() {
        chanse.setText("You've " + totalChances + " more Chances");
    }

}

