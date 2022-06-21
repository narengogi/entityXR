package com.XR.nodeXR.service;

import com.XR.nodeXR.model.History;
import com.XR.nodeXR.repository.HistoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HistoryProcessor {
    FileInputStream file;
    HistoryRepository historyRepository;

    public HistoryProcessor(String filename) throws IOException {
        this.file = new FileInputStream("/home/vennela/Downloads/tmp/" + filename);
    }

    public void processFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<History> historyList = Arrays.asList(mapper.readValue(file, History[].class));
        historyList.forEach(System.out::println);
        for(History historyItem : historyList) {
           historyRepository.save(historyItem);
        }
    }

    private void mapObjects() {
    }

}
