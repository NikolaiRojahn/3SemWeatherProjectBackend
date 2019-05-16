//package threads;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeoutException;
//
//public class FetchExecutor {
//
//    List<String> urlStrs;
//
//    public FetchExecutor(List<String> urlStr) {
//        this.urlStrs = urlStr;
//    }
//
//    public List<String> run() throws InterruptedException, ExecutionException, TimeoutException {
//        
//        List<Future<String>> futuresList = new ArrayList();
//        List<String> resultList = new ArrayList();
//        
//        ExecutorService exService = Executors.newCachedThreadPool();
//        
//        for (String urlStr : urlStrs) {
//            Future<String> future = exService.submit(new FetchCallable(urlStr));
//            futuresList.add(future);
//        }
//        
//        for (Future<String> future : futuresList) {
//            resultList.add(future.get());
//        }
//
//        exService.shutdown();
//
//        return resultList;
//    }
//
//}