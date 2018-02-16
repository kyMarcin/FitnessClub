package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.Main;
import sample.SceneManager;
import sample.StageManager;

import java.io.IOException;

public class StartLayoutController {

    private static final String ADMINISTRATOR_LAYOUT_LOCATION = "src/sample/gui/AdministratorLayout.fxml";
    private static final String USER_LAYOUT_LOCATION = "src/sample/gui/UserLayout.fxml";

    @FXML
    private void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void handleHelp(ActionEvent actionEvent) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Info");
        infoAlert.setContentText("Simple project for \"Database systems\" subject");
        infoAlert.show();
    }

    @FXML
    private void handleAdministratorButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene administratorScene = SceneManager.getNewScene(ADMINISTRATOR_LAYOUT_LOCATION);
        StageManager.setScene(mainStage, administratorScene);
    }

    @FXML
    private void handleUserButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene administratorScene = SceneManager.getNewScene(USER_LAYOUT_LOCATION);
        StageManager.setScene(mainStage, administratorScene);
    }
}
