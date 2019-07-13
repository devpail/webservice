package com.devpail.webservice.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 18:14
 **/

@Service
public class DocumentService {
    public String getDocument(String id) {
        id = "53553ce8-d5fe-475c-84ec-1ae9fa2f7f13";
        Path filePath = Paths.get("E:",id+".xml");
        return readFileByFileInputStream(filePath);
    }

    private String readFileByFileInputStream(Path filePath){
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String content = new String(bytes, StandardCharsets.UTF_8);
            return content.length()+"";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
