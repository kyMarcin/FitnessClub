package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    private static final String ROOM_LAYOUT_LOCATION = "src/sample/gui/datamanipulation/RoomLayout.fxml";
    private static final String TICKET_LAYOUT_LOCATION = "src/sample/gui/datamanipulation/TicketLayout.fxml";
    private static final String DISCOUNT_TYPE_LAYOUT_LOCATION = "src/sample/gui/datamanipulation/DiscountTypeLayout.fxml";

    @FXML
    private void handleBackButtonAction(ActionEvent actionEvent) throws IOException {
        Stage mainStage = Main.getMainStage();
        Scene startScene = Main.getStartScene();
        StageManager.setScene(mainStage, startScene);
    }

    @FXML
    private void handleRoomsButtonAction(ActionEvent actionEvent) throws IOException {
        Scene roomScene = SceneManager.getNewScene(ROOM_LAYOUT_LOCATION);
        StageManager.openNewWindow(roomScene);
    }

    @FXML
    private void handleTicketButtonAction(ActionEvent actionEvent) throws IOException {
        Scene ticketScene = SceneManager.getNewScene(TICKET_LAYOUT_LOCATION);
        StageManager.openNewWindow(ticketScene);
    }

    public void handleDiscountButtonAction(ActionEvent actionEvent) throws IOException {
        Scene discountScene = SceneManager.getNewScene(DISCOUNT_TYPE_LAYOUT_LOCATION);
        StageManager.openNewWindow(discountScene);
    }
}
