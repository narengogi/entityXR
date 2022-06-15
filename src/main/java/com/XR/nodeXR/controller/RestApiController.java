package com.XR.nodeXR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @GetMapping("/test")
    boolean testApi() {
        return true;
    }
}
