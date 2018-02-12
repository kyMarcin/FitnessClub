package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class StartLayoutController {

    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void handleHelp(ActionEvent actionEvent) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Info");
        infoAlert.setContentText("Simple project for \"Database systems\" subject");
        infoAlert.show();
    }
}
