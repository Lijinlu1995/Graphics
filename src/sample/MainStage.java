/*Produce a visual rendering of a javaFx stage
* on Windows Fxml loader the sample.fxml*/
package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainStage extends Stage {
    private double width = 1000;
    private double height = 600;
    public MainStage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        setTitle("Sample Draw App");
        setScene(new Scene(root,width,height, Color.web("#949494")));

        show();
    }
}

