package com.cdy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * todo
 * Created by 陈东一
 * 2018/7/29 10:28
 */
@Controller
@Slf4j
public class IstioController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${remoting.web}")
    private String webhost;
    
    @RequestMapping("/version")
    @ResponseBody
    public String version(String headKey, String headValue) {
        log.info("version");
        if (StringUtils.isEmpty(headKey)) {
            return restTemplate.getForEntity(webhost + "/version", String.class).getBody();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headKey, headValue);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(webhost + "/version", HttpMethod.GET, httpEntity, String.class).getBody();
    }
    
    @RequestMapping("/timeout")
    @ResponseBody
    public String timeout(@RequestParam(value = "time") Integer time) {
        log.info("timeout");
        return restTemplate.getForEntity(webhost + "/version?time=" + time, String.class).getBody();
    }
    
}
