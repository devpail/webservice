package com.devpail.webservice.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 18:14
 **/

@Service
public class DocumentService {
    public String getDocument(String id) {
        id = "484fa554-218b-46fa-afa8-533879a0a334";
        Path filePath = Paths.get("E:",id+".xml");
        return readFileByFileInputStream(filePath);
    }

    private String readFileByFileInputStream(Path filePath){
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            Map map = new HashMap<String, String>();
            String content = new String(bytes, StandardCharsets.UTF_8);
            // return content.length()+"";
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
