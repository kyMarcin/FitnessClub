package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by Marcin on 14.02.2018.
 */
public class SceneManager {

    public static Scene getNewScene(String layoutLocation) throws IOException {
        URL layoutURL = Paths.get(layoutLocation).toUri().toURL();
        Parent parent = FXMLLoader.load(layoutURL);
        Scene newScene = new Scene(parent);
        return newScene;
    }

}
