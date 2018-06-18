import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class DownloadApp extends Application {
    @Override
    public void start(Stage stage) {
        DownloadView root = DownloadFactory.getDownloadView();

        Scene scene = new Scene(root, 300, 300);

        stage.setTitle("Download Application");
        stage.setScene(scene);
        stage.show();
    }
}
