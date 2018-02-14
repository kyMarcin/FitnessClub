package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage mainStage;
    private static Scene startScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("gui/StartLayout.fxml"));
        mainStage.setTitle("Fitness Club");
        startScene = new Scene(root, 600, 300);
        mainStage.setScene(startScene);
        mainStage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static Scene getStartScene() {
        return startScene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
