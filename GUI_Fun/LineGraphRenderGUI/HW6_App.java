
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.*;

public class HW6_App extends Application {

public void start(Stage stage){
    VBox root = new VBox();
    Line_GraphWidget lg = new Line_GraphWidget();
    InputWidget input = new InputWidget();
    root.getChildren().add(input);
    root.getChildren().add(lg);
    VBox.setVgrow(input, Priority.ALWAYS);
    VBox.setVgrow(lg, Priority.ALWAYS);

    Scene scene = new Scene(root, 600,600);
    stage.setTitle("HW6");
    stage.setScene(scene);
    stage.show();

  }
}
