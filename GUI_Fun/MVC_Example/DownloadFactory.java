public class DownloadFactory {
    public static DownloadView getDownloadView() {
        DownloadView view = new DownloadView();
        DownloadModel model = new DownloadModel();

        DownloadController controller = new DownloadController(view, model);

        return view;
    }
}
