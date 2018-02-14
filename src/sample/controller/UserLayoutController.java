package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;
import sample.StageManager;

import java.io.IOException;

/**
 * Created by Marcin on 12.02.2018.
 */
public class UserLayoutController {

    public void handleBackButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene startScene = Main.getStartScene();
        StageManager.setScene(mainStage, startScene);
    }
}
