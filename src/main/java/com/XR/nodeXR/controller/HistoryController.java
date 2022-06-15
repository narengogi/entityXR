package com.XR.nodeXR.controller;

import com.XR.nodeXR.resolver.HistoryResolver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryResolver historyResolver;

    public HistoryController() {
        this.historyResolver = new HistoryResolver();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResponseEntity uploadHistory(@RequestParam("browser") String browser, @RequestPart("myFile") FilePart file) {
        return historyResolver.historyUploader(file);
    }

}
