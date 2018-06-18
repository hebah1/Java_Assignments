import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.Vector;

public class SubmissionLog extends GridPane{
  static TextArea area = new TextArea();

  public SubmissionLog(){
    area.setEditable(false);
    add(area,0,0);
    setVgrow(area, Priority.ALWAYS);
    setHgrow(area, Priority.ALWAYS);
 }
 public static void logSubmission(String s){
   area.appendText(s);
   area.appendText("\n");
 }
}
