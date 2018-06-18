import java.util.Vector;
import javafx.concurrent.Task;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.nio.*;
import java.nio.file.*;

//import java.nio.channels.Channels;
//import java.nio.channels.ReadableByteChannel;

public class DownloadModel {
    private Vector<ErrorHandler> errorHandlers = new Vector<ErrorHandler>();
    private Vector<ResultsHandler> resultsHandlers = new Vector<ResultsHandler>();
    Task<Vector<DownloadResult>> task = null;
    boolean done = false;

    public void startFetch(String path) throws DownloadException {
        if (path.length() < 1) {
            throw new DownloadException("invalid path");
        }


        task = new Task<Vector<DownloadResult>>() {
          Vector<DownloadResult> results;

            @Override
            protected Vector<DownloadResult> call() throws Exception {
              Thread.sleep(3000);

                results = new Vector<DownloadResult>();
                  Path target = Paths.get(DownloadView.path);
                  Path in = Paths.get(DownloadView.url);
                  System.out.println("Running..");
                  Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
                  Thread.sleep(2000);
                  System.out.println("DONE");
                  done = true;
                return results;

            }
        };
        Thread th = new Thread(task);
        th.start();
    }

    public void addErrorHandler(ErrorHandler handler) {
        errorHandlers.add(handler);
    }

    private void fireErrorEvent(String error) {
        for (ErrorHandler eh: errorHandlers) {
            eh.handleError(error);
        }
    }

    public void addResultsHandler(ResultsHandler handler) {
        resultsHandlers.add(handler);
    }

    private void fireResultsEvent(Vector<DownloadResult> results) {
        for (ResultsHandler rh: resultsHandlers) {
            rh.handleResults(results);
        }
    }

    public boolean isDone(){
      return done;
    }
}
