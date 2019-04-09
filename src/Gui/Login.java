package Gui;

import com.company.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private TextField tetx1;

    @FXML
    private TextField tetx2;

    @FXML
    void Register(ActionEvent event) {
        GuiTest.stage.setScene(GuiTest.scene2);
    }

}
