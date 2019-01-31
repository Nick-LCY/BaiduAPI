package me.nick_lin.test_baidu_api.Services;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TranslationService {

    private static final String BAIDU_TRANS_API_URL = "https://fanyi-api.baidu.com/api/trans/vip/translate";
    private static final String APP_ID = "20190130000260587";
    private static final String KEY = "ESNjoHkfCACmfsFqY8e6";

    public static JSONObject translate(String query, String from, String to) {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();

        //Generate a random number
        int salt = getRandom();

        //Generate the sign
        String sign = encodeMD5Hex(APP_ID + query + salt + KEY);

        //Put all parameters into the JSON object
        request.put("q", query);
        request.put("from", from);
        request.put("to", to);
        request.put("appid", APP_ID);
        request.put("salt", salt);
        request.put("sign", sign);

//
//        //Using BaiDu's URL to create connection.
//        URL url;
//        HttpsURLConnection con = null;
//        try {
//            url = new URL(BAIDU_TRANS_API_URL);
//            con = (HttpsURLConnection) url.openConnection();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //Basic setting of this connection
//        con.setDoOutput(true);
//        con.setDoInput(true);
//        con.setUseCaches(false);
//        try {
//            con.setRequestMethod("POST");
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        }
//        con.setRequestProperty("Connection", "Keep-Alive");
//        con.setRequestProperty("Charset", "UTF-8");
//
//        //Get and set the length of JSON object
//        byte[] data = (request.toString()).getBytes();
//        con.setRequestProperty("Content-Length", String.valueOf(data.length));
//        con.setRequestProperty("contentType", "application/json");
//
//        //Connect
//        OutputStream out = null;
//        try {
//            con.connect();
//            out = con.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println((request.toString()).getBytes());
//
//        //Write request
//        try {
//            out.write((request.toString()).getBytes());
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //Get Response
//        try {
//            if (con.getResponseCode() == 200) {
//
//                //Response data
//                InputStream in = con.getInputStream();
//
//                byte[] data1 = new byte[in.available()];
//                in.read(data1);
//
//                //Turn to String
//                String a = new String(data1);
//                System.out.println(a);
//        } else {
//            System.out.println("no++");
//        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        return sendPOSTRequest((MultiValueMap<String, String>) request);
        return null;
    }

    private static String encodeMD5Hex(String data){
        return DigestUtils.md5Hex(data);
    }

    private static int getRandom() {
        //Using Timestamp to get a random number
        return (int) ((Math.random() + 1) * 10000);
    }

//    private static JSONObject sendPOSTRequest(MultiValueMap<String, String> data) {
//        RestTemplate client = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        HttpMethod method = HttpMethod.POST;
//        // 以表单的方式提交
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        //将请求头部和参数合成一个请求
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(data, headers);
//        //执行HTTP请求，将返回的结构使用ResultVO类格式化
//        ResponseEntity<JSONObject> response = client.exchange(BAIDU_TRANS_API_URL, method, requestEntity,JSONObject.class);
//
//        return response.getBody();
//    }

}
