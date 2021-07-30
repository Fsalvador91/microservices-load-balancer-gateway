package com.microservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ApiProxy apiProxy;

    @GetMapping("/techInfo/{platform}")
    public ResponseModel getTechInfo(@PathVariable("platform") String platform) {
        ResponseModel responseModel = apiProxy.retrieveTechInfo(platform);
        return responseModel;
    }
}
