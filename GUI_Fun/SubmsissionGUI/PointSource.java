import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.Vector;

public class PointSource extends GridPane{

  public PointSource(){

    Slider xCoord = new Slider(0,10,5);
    Slider yCoord = new Slider(0,10,5);
    Slider zCoord = new Slider(0,10,5);

    xCoord.setBlockIncrement(1);
    xCoord.setMajorTickUnit(10);

    add(xCoord, 0, 0);
    add(yCoord, 0, 1);
    add(zCoord, 0, 2);

    setHgap(10.0);
    setVgap(10.0);

    Region r = new Region();
    add(r,1,0);
    setVgrow(r, Priority.ALWAYS);
    setHgrow(r, Priority.ALWAYS);

    Button submit = new Button("Submit");
    add(submit, 2, 0);

    submit.setOnAction(
      (event) -> getPoint((int) xCoord.getValue(), (int) yCoord.getValue(), (int) zCoord.getValue())
      );
     }

 public void getPoint(int x, int y, int z){
   SubmissionLog.logSubmission(x+","+y+","+z);
 }
}
