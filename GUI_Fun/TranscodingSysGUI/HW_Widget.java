import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.*;
import java.lang.*;
import java.io.*;
import javafx.stage.*;
import javafx.scene.control.*;

class HW_Widget extends GridPane {
  String currSource;
  String tarSource;

    public HW_Widget() {

      setPrefSize(600, 600);

  //First Line
      TextField sourcetext = new TextField();
      sourcetext.setEditable(false);
      add(sourcetext, 0,0);
      setHgrow(sourcetext, Priority.ALWAYS);

      Button sourcebutton = new Button("Get Source");
      add(sourcebutton, 1, 0);
      sourcebutton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
  //Second Line
      TextField targettext = new TextField();
      targettext.setEditable(false);
      add(targettext, 0,1);

      Button targetbutton = new Button("Get Target");
      add(targetbutton, 1, 1);
      targetbutton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

  //Third Line
      Slider slide = new Slider();
      add(slide, 0,2);
  //Fourth Line
      Button start = new Button("Start");
      add(start, 1,3);
      start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

  //Fifth Line
      ProgressBar pb = new ProgressBar();
      add(pb, 0,4);
      pb.setMaxWidth(550);
      Button step = new Button("Step");
      step.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      add(step, 1, 4);
      setVgap(20.0);


      sourcebutton.setOnAction(
          (event) -> {
              FileChooser fileChooser = new FileChooser();
              File selectedFile = fileChooser.showOpenDialog(null);
                if (selectedFile != null){
                  sourcetext.setText(selectedFile.getAbsolutePath());
                  currSource = selectedFile.getAbsolutePath();
                }
          });

          targetbutton.setOnAction(
              (event) -> {
                  FileChooser fileChooser = new FileChooser();
                  File selectedFile = fileChooser.showSaveDialog(null);
                    if (selectedFile != null){
                      targettext.setText(selectedFile.getAbsolutePath());
                      tarSource = selectedFile.getAbsolutePath();

                    }
              });

          start.setOnAction(
              (event) -> {
                if(sourcetext.getText().isEmpty() == true | targettext.getText().isEmpty() == true){
                  Alert a = new Alert(AlertType.ERROR);
                  a.setContentText("Must select file");
                  a.showAndWait();
                }else{
                  pb.setProgress(.10);
                }
              });

          step.setOnAction(
            (event) -> {

              if(pb.getProgress() < 1){
                pb.setProgress(pb.getProgress()+ .1);
              } else if(pb.getProgress() >= 1){
                  pb.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
                  Alert a = new Alert(AlertType.INFORMATION);
                  a.setContentText("Encoding is Complete");
                  a.showAndWait();
                }
                if(pb.isIndeterminate() == true){
                }
          });
    }
}
