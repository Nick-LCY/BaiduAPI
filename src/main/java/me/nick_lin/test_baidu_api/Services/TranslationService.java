package me.nick_lin.test_baidu_api.Services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class TranslationService {

    private static final String BAIDU_TRANS_API_URL = "https://fanyi-api.baidu.com/api/trans/vip/translate";
    private static final long APP_ID = 0000000000L;
    private static final String KEY = "Your Key";

    public static String translate(String query, String from, String to) {
        String finalURL;

        //Generate a random number
        int salt = getRandom();

        //Generate the sign
        String sign = encodeMD5Hex(APP_ID + query + salt + KEY);

        //Put all parameters into the URL
        finalURL = BAIDU_TRANS_API_URL + "/?q=" + query
                + "&from=" + from + "&to=" + to
                + "&appid=" + APP_ID + "&salt=" + salt
                + "&sign=" + sign;

        return sendGETRequest(finalURL);
    }

    private static String encodeMD5Hex(String data){
        return DigestUtils.md5Hex(data);
    }

    private static int getRandom() {
        //Get a random number
        return (int) ((Math.random() + 1) * 10000);
    }

    private static String sendGETRequest( String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String answer = restTemplate.getForObject(url, String.class);
        return answer;
    }

}
