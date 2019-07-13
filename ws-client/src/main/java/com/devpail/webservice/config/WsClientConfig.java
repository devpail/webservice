package com.devpail.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2019-07-13 15:20
 **/

@Configuration
public class WsClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //会扫描此类下面的对应的 jaxb2实体类 因为是使用 Marshaller和 unmarshaller来进行xml和bean直接转换的
        //具体是判断此路径下是否包含 ObjectFactory.class 文件
        //设置 JAXBContext 对象
        marshaller.setContextPath("com.devpail.webservice.client");
        //或者使用 以下方式设置
//        marshaller.setPackagesToScan(packagesToScan);
//        marshaller.setClassesToBeBound(classesToBeBound);
        return marshaller;
    }

    /*
     * 创建bean
     */
    @Bean
    public WsClient wsClient(Jaxb2Marshaller marshaller) {
        WsClient client = new WsClient();
        //默认对应的ws服务地址 client请求中还能动态修改的
        client.setDefaultUri("http://localhost:8080/ws/document.wsdl");
        client.setMarshaller(marshaller);//指定转换类
        client.setUnmarshaller(marshaller);
        return client;
    }
}
