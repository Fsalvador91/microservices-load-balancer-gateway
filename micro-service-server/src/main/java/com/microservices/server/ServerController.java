package com.microservices.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private Environment environment;

    @GetMapping("/techInfo/{platform}")
    public ResponseModel retrieveTechInfo(@PathVariable("platform") String platform) {
        ResponseModel responseModel = new ResponseModel();

        switch (platform) {
            case "Java":
                responseModel.setTitle("Tech Stack");
                responseModel.setPlatform("Java");
                responseModel.setUsedFor("Secured Web Services");
                break;
            case "Python":
                responseModel.setTitle("Technology Stack");
                responseModel.setPlatform("Python");
                responseModel.setUsedFor("Machine Learning");
                break;
            default:
                responseModel.setTitle("Technology Stack");
                responseModel.setPlatform(platform);
                responseModel.setUsedFor("Unknown platform");
        }

        responseModel.setServerPort(Short.parseShort(environment.getProperty("local.server.port")));

        return responseModel;
    }
}
