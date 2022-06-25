package com.XR.nodeXR.controller;

import com.XR.nodeXR.repository.HistoryRepository;
import com.XR.nodeXR.resolver.HistoryResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryRepository historyRepository;

    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResponseEntity uploadHistory(@RequestParam("browser") String browser, @RequestPart("myFile") FilePart file) {
        try {
            HistoryResolver historyResolver = new HistoryResolver(historyRepository, file);
            historyResolver.uploadFile();
            historyResolver.processFile();
        } catch (Exception e) {
            File fileToBeDeleted = new File("/home/vennela/Downloads/tmp/" + file.filename());
            fileToBeDeleted.delete();
            return new ResponseEntity("Unable To Process the file", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity("File Uploaded SuccessFully", HttpStatus.OK);
    }

}
