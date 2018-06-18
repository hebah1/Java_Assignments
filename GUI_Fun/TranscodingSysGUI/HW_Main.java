import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

 class HW_Main extends GridPane {

   public HW_Main(){

  Button button = new Button("Add Transcode");

  TabPane tabPane = new TabPane();

  tabPane.setPrefSize(500, 500);

   add(tabPane, 0,0);
   add(button, 1, 3);

   setHgrow(tabPane, Priority.ALWAYS);
   setVgrow(tabPane, Priority.ALWAYS);

  button.setOnAction(
  (event) -> {
    Tab newTab = new Tab();
    ScrollPane spane = new ScrollPane();
    spane.setContent(new HW_Widget());
    newTab.setContent(spane);
    tabPane.getTabs().addAll(newTab);
    newTab.setText("New Tab");

  setHgrow(spane, Priority.ALWAYS);
  setVgrow(spane, Priority.ALWAYS);



});

   }

}
