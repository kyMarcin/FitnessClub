package sample.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by Marcin on 14.02.2018.
 */
public class SceneManager {

    public enum Color {

        GREEN("#0fe77e"),
        RED("#da0f0f");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    private SceneManager(){}

    public static Scene getNewScene(String layoutLocation) throws IOException {
        URL layoutURL = Paths.get(layoutLocation).toUri().toURL();
        Parent parent = FXMLLoader.load(layoutURL);
        Scene newScene = new Scene(parent);
        return newScene;
    }

    public static void setLabel(Label label, Color color, String text) {
        label.setTextFill(Paint.valueOf(color.getColor()));
        label.setText(text);
    }

}
