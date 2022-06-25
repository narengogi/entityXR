package com.XR.nodeXR.resolver;

import com.XR.nodeXR.model.History;
import com.XR.nodeXR.repository.HistoryRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.codec.multipart.FilePart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HistoryResolver {
    private final HistoryRepository historyRepository;
    private final FilePart file;

    public HistoryResolver (HistoryRepository historyRepository, FilePart file) {
        this.historyRepository = historyRepository;
        this.file = file;
    }

    public void uploadFile() {
        file.transferTo(new File("/home/vennela/Downloads/tmp/" + file.filename())).subscribe();
    }

    public void processFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileInputStream inputFile = new FileInputStream("/home/vennela/Downloads/tmp/" + file.filename());
        List<History> historyList = Arrays.asList(mapper.readValue(inputFile, History[].class));
        for(History historyItem : historyList) {
            historyRepository.save(historyItem).subscribe(item -> System.out.println(item.getTitle()));
        }
    }
}