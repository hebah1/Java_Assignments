import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.Vector;

public class SelectionSource extends GridPane{

  public SelectionSource(){

    RadioButton rb1 = new RadioButton("Selection 1");
    RadioButton rb2 = new RadioButton("Selection 2");
    RadioButton rb3 = new RadioButton("Selection 3");
    RadioButton rb4 = new RadioButton("Selection 4");

    rb1.setUserData("Selection 1");
    rb2.setUserData("Selection 2");
    rb3.setUserData("Selection 3");
    rb4.setUserData("Selection 4");

    ToggleGroup tg = new ToggleGroup();

    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);
    rb3.setToggleGroup(tg);
    rb4.setToggleGroup(tg);
    add(rb1, 0, 0);
    add(rb2, 0, 1);
    add(rb3, 0, 2);
    add(rb4, 0, 3);

    setHgap(10.0);
    setVgap(10.0);

    Region r = new Region();
    add(r,1,2);

    setVgrow(r, Priority.ALWAYS);
    setHgrow(r, Priority.ALWAYS);

    Button submit = new Button("Submit");
    add(submit, 2, 0);

    submit.setOnAction(
      (event) -> getSelection(tg.getSelectedToggle().getUserData().toString())
    );
 }
 
 public void getSelection(String s){
   SubmissionLog.logSubmission(s);
 }
}
