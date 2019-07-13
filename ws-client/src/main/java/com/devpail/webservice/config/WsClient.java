package com.devpail.webservice.config;

import com.devpail.webservice.client.DocumentRequest;
import com.devpail.webservice.client.DocumentResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 15:05
 **/

public class WsClient extends WebServiceGatewaySupport {
    /**
     *  获取文档
     *  @author zhangzhb
     */
    public DocumentResponse getDocument(String code) {
        DocumentRequest req = new DocumentRequest();
        req.setId(code);
        //使用 marshalSendAndReceive 进行调用
        return (DocumentResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

}
