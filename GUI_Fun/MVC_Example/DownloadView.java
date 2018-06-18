import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.event.*;

import javafx.stage.FileChooser;

import java.util.Vector;

import java.io.File;

public class DownloadView extends GridPane{
  private TextField urlField;
  private TextField pathField;
  public static Button start;
  public static String path;
  public static String url;

  private Vector<PathHandler> pathHandlers;

  public DownloadView(){
     urlField = new TextField();
    pathField = new TextField();
     Button select = new Button("Select");
      start = new Button("Start");
      start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      select.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      urlField.setPromptText("Enter URL");
      pathField.setPromptText("Enter Path");
      add(urlField, 0, 0);
      add(pathField, 0, 1);
      add(select, 2, 1);
      add(start, 2, 2);
      setVgap(15.0);

      Region r = new Region();
      setHgrow(r, Priority.ALWAYS);

      add(r, 1, 0);


      select.setOnAction(
        (event) -> {
          FileChooser chooser = new FileChooser();
          chooser.setTitle("Choose a File");

          File selected = chooser.showSaveDialog(null);
            if (selected != null) {
              pathField.setText(selected.toString());
        }
      });
      path = pathField.getText().toString();
      url = urlField.getText().toString();

     start.setOnAction(
        (ActionEvent event) -> {
          if (urlField.getText().isEmpty() == true){
            showError();
          }else{
            setDisableState();
            firePathEvent();
          }
        }
        );

      pathHandlers = new Vector<PathHandler>();
    }
    public void showError(String error) {
        Alert a = new Alert(AlertType.ERROR, error, ButtonType.OK);
        a.showAndWait();
    }
    public void showError() {
        Alert a = new Alert(AlertType.ERROR);
        a.setContentText("Must Enter a URL");
        a.showAndWait();
    }
    public void showCompleted() {
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setContentText("Download Completed");
        a.showAndWait();
    }

    public void setDisableState(){
      start.setDisable(true);
    }

    public  void setReadyState(){
      start.setDisable(false);
    }

    public void addPathHandler(PathHandler handler) {
        pathHandlers.add(handler);
    }

    private void firePathEvent() {
        for (PathHandler ph: pathHandlers) {
            ph.handlePath(pathField.getText());
        }
    }
}
