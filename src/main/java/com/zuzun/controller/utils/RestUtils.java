package com.zuzun.controller.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestUtils {

    public String postRestTemplate(String url,Object object){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, object, String.class);
        return response;
    }

    public String getRestTemplate(String url){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        return response;
    }

    public void putRestTemplate(String url,Object object){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, object);
    }

    public void deleteRestTemplate(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }

}
