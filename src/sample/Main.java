/*Main class to control the whole project
* through call for the MainStage.java*/
package sample;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        new MainStage();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
