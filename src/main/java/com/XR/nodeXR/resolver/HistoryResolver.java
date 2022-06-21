package com.XR.nodeXR.resolver;

import com.XR.nodeXR.service.HistoryProcessor;

import org.springframework.http.codec.multipart.FilePart;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HistoryResolver {

    public void historyUploader(FilePart file) throws IOException {
        file.transferTo(new File("/home/vennela/Downloads/tmp/" + file.filename())).block(Duration.ofSeconds(5));
        HistoryProcessor historyProcessor = new HistoryProcessor(file.filename());
        historyProcessor.processFile();
    }
}