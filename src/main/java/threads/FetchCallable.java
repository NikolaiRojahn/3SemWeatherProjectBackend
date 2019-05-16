//
//package threads;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Scanner;
//import java.util.concurrent.Callable;
//
//public class FetchCallable implements Callable<String>{
//    private String urlStr;
//    
//    public FetchCallable(String url){
//        this.urlStr = url;
//    }
//
//    @Override
//    public String call() throws Exception {
//        URL url = new URL(urlStr);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
//        con.setRequestProperty("User-Agent", "server");
//        Scanner scan = new Scanner(con.getInputStream());
//        String jsonStr = null;
//        if (scan.hasNext()) {
//            jsonStr = scan.nextLine();
//        }
//        scan.close();
//        return jsonStr;
//       
//    }
//    
//}