package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;
import sample.SceneManager;
import sample.StageManager;

import java.io.IOException;

/**
 * Created by Marcin on 12.02.2018.
 */
public class AdministratorLayoutController {

    private static final String ADD_ROOMS_LAYOUT_LOCATION = "src/sample/gui/datamanipulation/AddRoomsLayout.fxml";

    public void handleBackButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene startScene = Main.getStartScene();
        StageManager.setScene(mainStage, startScene);
    }

    public void handleAddRoomsButton(ActionEvent actionEvent) throws IOException {
        Scene addRoomsScene = SceneManager.getNewScene(ADD_ROOMS_LAYOUT_LOCATION);
        StageManager.openNewWindow(addRoomsScene);
    }
}
