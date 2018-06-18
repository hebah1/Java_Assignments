import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.*;
import javafx.scene.canvas.GraphicsContext;
import java.util.*;

import javafx.stage.*;

public class Line_GraphWidget extends GridPane {
  private VBox box;
  static Canvas canvas;
  static GraphicsContext gc;
  static ArrayList<Integer> values;
  public Line_GraphWidget(){
    box = new VBox();
    add(box, 0, 0);
    canvas = new Canvas(500, 400);
    box.getChildren().add(canvas);
    values = new ArrayList<Integer>();
    gc = canvas.getGraphicsContext2D();
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(5);
  }

    public static void drawLine(){
      int xdist = 75;
      for(int i = 0; i < values.size()-1; i++){
      gc.strokeLine(xdist, (int) values.get(i), (xdist+10), (int) values.get(i+1));
      xdist+=10;
    }
  }

  public static void clear(){
    gc.clearRect(0, 0, 500, 400);
  }
}
