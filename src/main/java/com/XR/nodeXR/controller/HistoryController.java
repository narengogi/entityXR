package com.XR.nodeXR.controller;

import com.XR.nodeXR.resolver.HistoryResolver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryResolver historyResolver;

    public HistoryController() {
        this.historyResolver = new HistoryResolver();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    boolean uploadHistory(@RequestPart("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        return true;
//        return historyResolver.historyUploader(file);
    }

}
