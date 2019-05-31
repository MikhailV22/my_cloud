package com.example.eurekaclient.Controllers;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Greeting() {
    }

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/greeting")
    public String greeting() {
        return String.format("Hello from '%s'!", discoveryClient.getInstances(appName).get(0).getServiceId());
    }
}
