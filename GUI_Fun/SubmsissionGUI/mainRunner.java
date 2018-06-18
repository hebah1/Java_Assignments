import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;

import javafx.stage.*;

public class mainRunner extends Application {

public void start(Stage stage){

  VBox root = new VBox(20);

  PointSource ps = new PointSource();
  TextSource ts = new TextSource();
  SelectionSource ss = new SelectionSource();
  SubmissionLog sl = new SubmissionLog();

  root.getChildren().add(ps);
  root.getChildren().add(ts);
  root.getChildren().add(ss);
  root.getChildren().add(sl);

  VBox.setVgrow(sl, Priority.ALWAYS);

  Scene scene = new Scene(root,400,400);

  stage.setTitle("HW4");
  stage.setScene(scene);
  stage.show();
  }
  }
