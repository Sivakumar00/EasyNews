package com.siva;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyNews {

    public static String API_KEY="";


    public static void initialize(String API){
        API_KEY=API;

    }

    public static List<Map> getNewsByLanguage(String language) {

        if(API_KEY != ""){

            String reqURL = "https://newsapi.org/v2/sources?language=" + language + "&apiKey="+API_KEY;

            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(reqURL);
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpResponse response = null;
            try {
                response = client.execute(httpGet);
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
            HttpEntity entity = response.getEntity();
            String responseString = null;
            try {
                responseString = EntityUtils.toString(entity, "UTF-8");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            JSONObject jsonObject = new JSONObject(responseString);


            JSONArray articleArray = jsonObject.getJSONArray("sources");
            List<Map> finalList = new ArrayList<Map>();

            for (int i = 0; i < articleArray.length(); i++) {
                finalList = mappingList(articleArray, i);
            }

            return finalList;
        }else {
            System.out.println("NULL POINTER EXCEPTION: API_KEY or MISSING intialize()");
            return null;
        }
    }

    public static List<Map> getNewsByCategory(String category) {

        if(API_KEY != "") {

            String reqURL="https://newsapi.org/v2/sources?category="+category+"&apiKey="+API_KEY;

            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(reqURL);
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpResponse response = null;
            try {
                response = client.execute(httpGet);
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
            HttpEntity entity = response.getEntity();
            String responseString = null;
            try {
                responseString = EntityUtils.toString(entity, "UTF-8");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            JSONObject jsonObject = new JSONObject(responseString);


            JSONArray articleArray=jsonObject.getJSONArray("sources");
            List<Map> finalList=new ArrayList<Map>();

            for(int i=0;i<articleArray.length();i++){
                finalList=mappingList(articleArray,i);
            }

            return finalList;
    }
    else {
            System.out.println("NULL POINTER EXCEPTION: API_KEY or MISSING intialize()");
            return null;
    }
    }



    public static List<Map> getNewsByKeywords(String query) {

        if(API_KEY != "") {

            String reqURL="https://newsapi.org/v2/everything?q="+query+"&apiKey="+API_KEY;

            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(reqURL);
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpResponse response = null;
            try {
                response = client.execute(httpGet);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            HttpEntity entity = response.getEntity();
            String responseString = null;
            try {
                responseString = EntityUtils.toString(entity, "UTF-8");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            JSONObject jsonObject = new JSONObject(responseString);
            JSONArray articleArray=jsonObject.getJSONArray("articles");
            List<Map> list=new ArrayList<Map>();
            for(int i=0;i<articleArray.length();i++){
                list= mappingListArticle(articleArray,i);
            }

            return list;
    }
    else {
        System.out.println("NULL POINTER EXCEPTION: API_KEY or MISSING intialize()");
        return null;
        }
    }

    public static List<Map> getHeadLinesByCountry(String country){

        if(API_KEY != "") {
            String reqURL="https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+API_KEY;
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(reqURL);
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpResponse response = null;
            try {
                 response = client.execute(httpGet);
            } catch (IOException e) {
                 System.out.println(e.getMessage());
            }
            HttpEntity entity = response.getEntity();
            String responseString = null;
            try {
                 responseString = EntityUtils.toString(entity, "UTF-8");

            } catch (IOException e) {
                 System.out.println(e.getMessage());
            }
            JSONObject jsonObject = new JSONObject(responseString);
            JSONArray articleArray=jsonObject.getJSONArray("articles");
            List<Map> list=new ArrayList<Map>();
            for(int i=0;i<articleArray.length();i++){
                list= mappingListArticle(articleArray,i);
            }

            return list;
        }
        else {
            System.out.println("NULL POINTER EXCEPTION: API_KEY or MISSING intialize()");
        return null;
        }
     }


    private static List<Map> mappingList(JSONArray sourceArray,int i){
        List<Map> list=new ArrayList<Map>();
        JSONObject count=sourceArray.getJSONObject(i);
        Map<String,String> map=new HashMap<>();
        map.put("id",count.optString("id"));
        map.put("name",count.optString("name"));
        map.put("description",count.optString("description"));
        map.put("url",count.optString("url"));
        map.put("category",count.optString("category"));
        map.put("language",count.optString("language"));
        map.put("country",count.optString("country"));

        list.add(map);
        return list;
    }

    private static List<Map> mappingListArticle(JSONArray articleArray,int i){
        List<Map> list=new ArrayList<Map>();
        JSONObject count=articleArray.getJSONObject(i);
        Map<String,String> map=new HashMap<>();
        map.put("author",count.optString("author"));
        map.put("title",count.optString("title"));
        map.put("description",count.optString("description"));
        map.put("url",count.optString("url"));
        map.put("urlToImage",count.optString("urlToImage"));
        map.put("publishedAt",count.optString("publishedAt"));


        list.add(map);
        return list;
    }


}
