import java.util.Vector;

public class DownloadController {
    DownloadView view = null;
    DownloadModel model = null;

    public DownloadController(DownloadView view, DownloadModel model) {
        this.view = view;
        this.model = model;

        view.addPathHandler(
            (String path) -> {
                try {
                  view.setDisableState();
                  model.startFetch(path);

                } catch (DownloadException re){
                  System.out.println("ERROR");
                    view.showError(re.getMessage());
                    view.setReadyState();
                }
            });

        model.addErrorHandler(
            (String error) -> {
                view.showError(error);
            }
        );
    }
}
