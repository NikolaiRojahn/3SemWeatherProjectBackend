package threads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleFutureCallable {

    public String run(String url) throws InterruptedException, ExecutionException {
        final ExecutorService exService = Executors.newSingleThreadExecutor();
        final Future<String> callFuture = exService.submit(new SingleFutureCallable().new CallableThread(url));
        final String callval = callFuture.get();
        exService.shutdown();
        return callval;
    }

    // Callable thread
    class CallableThread implements Callable<String> {

        private String urlStr;

        public CallableThread(String url) {
            this.urlStr = url;
        }

        @Override
        public String call() throws IOException {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("User-Agent", "server");
            Scanner scan = new Scanner(con.getInputStream());
            String jsonStr = null;
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
            scan.close();
            return jsonStr;
        }
    }
}
