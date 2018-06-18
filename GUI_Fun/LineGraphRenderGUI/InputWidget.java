import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import java.util.*;

public class InputWidget extends GridPane {

  public InputWidget(){
    setHgap(10);
	Label label = new Label("Enter values (Ex: 10,50,30,40)");
	add(label, 0,0);
    TextField input = new TextField();
    setHgrow(input, Priority.ALWAYS);
    add(input, 1, 0);
    Region r = new Region();
    add(r,2,0);
    setVgrow(r, Priority.ALWAYS);
    setHgrow(r, Priority.ALWAYS);

    Button submit = new Button("Submit");
    add(submit, 3, 0);

    submit.setOnAction(
    (event) -> {
    
     if ()
      Line_GraphWidget.clear();
      getValues(input.getText());
      Line_GraphWidget.drawLine();
    }
    );
  }
  public void getValues(String str){
    StringTokenizer tokenizer = new StringTokenizer(str, ",");
      int n = tokenizer.countTokens();
      for (int i = 0; i < n; i++) {
        String token = tokenizer.nextToken();
        Line_GraphWidget.values.add(i, Integer.parseInt(token));
      }
  }

}
