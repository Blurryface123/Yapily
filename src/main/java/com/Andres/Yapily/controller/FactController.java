package com.Andres.Yapily.controller;

import com.Andres.Yapily.entity.Fact;
import com.Andres.Yapily.entity.Response;
import com.Andres.Yapily.entity.Status;
import com.Andres.Yapily.service.ApiConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;


@RestController
@RequestMapping("/")
public class FactController {


    @Autowired
    public ApiConsumer apiConsumer;

    @GetMapping(path = "/status",produces = MediaType.APPLICATION_JSON_VALUE)
    public Status getStatus() {
        Status status = new Status();
        Response resp = new Response();
        int uniqueValue = apiConsumer.getFactSize();
        if(apiConsumer.getStatus()){
            resp.setTotal(1000);
            resp.setUnique(uniqueValue);
            status.setStatus("COMPLETE");
            status.setResponse(resp);
        }else {
            resp.setTotal(0);
            resp.setUnique(uniqueValue);
            status.setStatus("FAILED");
            status.setResponse(resp);
        }
        return status;
    }

    @GetMapping(path = "/facts",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getId(){
        return apiConsumer.getUniqueId();
    }
    @GetMapping(path = "/facts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Fact getFactById(@PathVariable String id) {
        return apiConsumer.getFactById(id);
    }
}
