import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class homecontroller {
    private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Button btn_continue;

    @FXML
    private TextField pin;

    int entrypin = 1234;
    @FXML
    void switchpaymentpage(ActionEvent event) throws IOException{
        try {
            String inputpinStr = pin.getText();
            int inputpin = Integer.parseInt(inputpinStr);

            if(inputpin == entrypin){
                root = FXMLLoader.load(getClass().getResource("paymentpage.fxml"));
		        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
            }
            else{
                JOptionPane.showMessageDialog(null, "You enter a wrong pin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
