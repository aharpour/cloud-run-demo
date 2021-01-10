package com.aharpour.cloud.run.demo.web;

import com.aharpour.cloud.run.demo.service.InstanceIdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final InstanceIdService instanceIdService;

    public Controller(InstanceIdService instanceIdService) {
        this.instanceIdService = instanceIdService;
    }

    @GetMapping("/")
    public String greet() {
        return "{ \"greeting\": \"Hello World!\", \"id\": " + instanceIdService.getId() + "}";
    }
}
