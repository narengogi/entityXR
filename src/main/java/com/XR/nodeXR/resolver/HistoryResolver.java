package com.XR.nodeXR.resolver;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HistoryResolver {
    public boolean historyUploader(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return true;
    }
}
