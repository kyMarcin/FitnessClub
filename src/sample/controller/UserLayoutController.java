package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;
import sample.window.SceneManager;
import sample.window.StageManager;

import java.io.IOException;

/**
 * Created by Marcin on 12.02.2018.
 */
public class UserLayoutController {

    private static final String SALE_LAYOUT_LOCATION = "src/sample/gui/datamanipulation/SaleLayout.fxml";

    @FXML
    private void handleBackButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene startScene = Main.getStartScene();
        StageManager.setScene(mainStage, startScene);
    }

    @FXML
    private void saleButtonAction(ActionEvent actionEvent) throws IOException {
        Scene saleScene = SceneManager.getNewScene(SALE_LAYOUT_LOCATION);
        StageManager.openNewWindow(saleScene);
    }
}
