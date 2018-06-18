import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.Vector;

public class TextSource extends GridPane{

  public TextSource(){

    TextField tf = new TextField();
    add(tf, 0, 0);

    Region r = new Region();
    add(r,1,0);

    setVgrow(r, Priority.ALWAYS);
    setHgrow(r, Priority.ALWAYS);

    Button submit = new Button("Submit");
    add(submit, 2, 0);

    submit.setOnAction(
      (event) -> getText(tf.getText())
      );
 }

 public void getText(String s){
   SubmissionLog.logSubmission(s);
 }

}
