import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HW3_App extends Application {
    @Override
    public void start(Stage primaryStage) {
       HW_Widget bw = new HW_Widget();
       HW_Main main = new HW_Main();

        primaryStage.setTitle("Hw3");
        primaryStage.setScene(new Scene(main, 650, 500));
        primaryStage.show();
    }
}
