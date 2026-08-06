package org.a1aska17.bookhub.controller;

import org.a1aska17.bookhub.dto.AppInfoDto;
import org.a1aska17.bookhub.dto.AppMessageDto;
import org.a1aska17.bookhub.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final HelloService helloService;

    HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public AppMessageDto getHello() {
        return helloService.createAndReturnMessage();
    }

    @GetMapping("/info")
    public AppInfoDto getInfo() {
        return helloService.createAndReturnInfo();
    }

    @GetMapping("/ping")
    public String getPing() {
        return "pong";
    }
}
