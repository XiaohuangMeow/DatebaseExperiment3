package Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiTest extends Application {

    protected static Stage stage;
    protected static Scene scene1;
    protected static Scene scene2;
    protected static Scene scene3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Gui/Login.fxml"));
        scene1=new Scene(root);

        Parent root2 = FXMLLoader.load(getClass().getResource("/Gui/Register.fxml"));
        scene2=new Scene(root2);

        stage=primaryStage;

        stage.setScene(scene1);
        stage.show();
    }
}
