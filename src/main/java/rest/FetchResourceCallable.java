///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rest;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Scanner;
//import java.util.concurrent.Callable;
//
///**
// *
// * @author oertel
// */
//public class FetchResourceCallable implements Callable<String>{
//    String urlStr;
//    
//    public FetchResourceCallable(String url){
//        this.urlStr = url;
//    }
//
//    @Override
//    public String call() throws Exception {
//       //ex.doWork();
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
