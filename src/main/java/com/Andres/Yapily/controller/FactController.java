package com.Andres.Yapily.controller;

import com.Andres.Yapily.entity.Fact;
import com.Andres.Yapily.entity.Response;
import com.Andres.Yapily.entity.SimpleErrorException;
import com.Andres.Yapily.entity.Status;
import com.Andres.Yapily.service.ApiConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
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
            throw new SimpleErrorException(HttpStatus.NO_CONTENT,"DATA FAILED TO LOAD");
        }
        return status;
    }

    @GetMapping(path = "/facts",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getId(){
        return apiConsumer.getUniqueId();
    }
    @GetMapping(path = "/facts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public Fact getFactById(@PathVariable String id, @RequestParam(required = false) String yandexKey, @RequestParam(required = false) String lang) {
        Fact translatedFact = apiConsumer.getFactById(id);
        System.out.println(yandexKey);
        System.out.println(lang);
        if (yandexKey != null && lang != null) {

            List<String> phrase = new ArrayList<>();
            String fromLang = translatedFact.getLanguage();
            phrase.add(translatedFact.getText());
            System.out.println("text to translate: " + phrase.toString());
            //textp traducido
            String transText = apiConsumer.translate(yandexKey, phrase, fromLang + "-" + lang);
            System.out.println("translated text: " + transText);
            translatedFact.setText(transText);
            translatedFact.setLanguage(lang);
        }else if(lang != null){
            throw new SimpleErrorException(HttpStatus.BAD_REQUEST,"PLEASE ADD YOUR YANDEX API KEY IF YOU WANT TO USE OTHER LANGUAGES");
        }

        return translatedFact;
    }
}
