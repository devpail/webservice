package com.devpail.webservice.endpoint;

import com.devpail.webservice.server.*;
import com.devpail.webservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;
import java.util.Date;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 18:02
 **/

@Endpoint
public class DocumentEndpoint {

    public static final String NAMESPACE_URI = "http://www.devpail.com/webservice";

    @Autowired
    private DocumentService documentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "documentRequest")
    @ResponsePayload
    public DocumentResponse getDocument(@RequestPayload DocumentRequest documentRequest){
        DocumentResponse documentResponse = new DocumentResponse();
        String document = documentService.getDocument(documentRequest.getId());
        documentResponse.setDocument(document);
        return documentResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "authorRequest")
    @ResponsePayload
    public AuthorResponse getAuthor(@RequestPayload AuthorRequest authorReq){
        AuthorResponse resp = new AuthorResponse();
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：" + authorReq.getName());
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + System.currentTimeMillis());
        resp.setAuthor(author);
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "authorListRequest")
    @ResponsePayload
    public AuthorListResponse getAuthorList(@RequestPayload AuthorListRequest request){
        AuthorListResponse resp = new AuthorListResponse();
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：oKong");
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + System.currentTimeMillis());
        resp.getAuthor().add(author);
        resp.getAuthor().add(author);
        return resp;
    }
}
