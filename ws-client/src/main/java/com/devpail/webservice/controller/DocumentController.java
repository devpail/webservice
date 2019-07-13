package com.devpail.webservice.controller;

import com.devpail.webservice.client.DocumentResponse;
import com.devpail.webservice.config.WsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 15:24
 **/
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    WsClient wsClient;

    @GetMapping("/get")
    public DocumentResponse getDocument(String id) {
        return wsClient.getDocument(id);
    }
}
