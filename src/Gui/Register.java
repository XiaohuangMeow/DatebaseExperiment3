package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Register {

    @FXML
    private TextField address;

    @FXML
    private TextField sex;

    @FXML
    private TextField name;

    @FXML
    private Button quit;

    @FXML
    private TextField age;

    @FXML
    private Button register;

    @FXML
    void quitAction(ActionEvent event) {
        GuiTest.stage.setScene(GuiTest.scene1);
    }

    @FXML
    void resisterAction(ActionEvent event) {
        System.out.println(name.toString());
        System.out.println("插入成功");
    }

}
