package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Marcin on 14.02.2018.
 */
public class StageManager {

    private StageManager(){}

    public static void setScene(Stage stage, Scene scene) throws IOException {
        stage.setScene(scene);
    }

    public static void openNewWindow(Scene scene) {
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
    }
}
