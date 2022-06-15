package com.XR.nodeXR.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HistoryProcessor {
    FileInputStream file;

    public HistoryProcessor(String filename) throws FileNotFoundException {
        this.file = new FileInputStream("/home/vennela/Downloads/tmp/" + filename);
    }

    private void processFile() {

    }

    private void mapObjects() {
    }

}
