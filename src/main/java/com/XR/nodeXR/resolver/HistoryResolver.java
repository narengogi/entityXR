package com.XR.nodeXR.resolver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;

import java.io.File;
import java.io.IOException;

public class HistoryResolver {
    public ResponseEntity historyUploader(FilePart file) {
        file.transferTo(new File("/home/vennela/Downloads/tmp/" + file.filename()));
        return new ResponseEntity("File Uploaded SuccessFully", HttpStatus.OK);
    }
}