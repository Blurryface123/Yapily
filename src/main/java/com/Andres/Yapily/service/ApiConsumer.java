package com.Andres.Yapily.service;


import com.Andres.Yapily.entity.Fact;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.ZonedDateTime;
import java.util.*;

@Service
public class ApiConsumer {

    public static final Map<String,Fact> uniqueRecords = new HashMap();

    static {
        final String BASE_URL = "https://uselessfacts.jsph.pl/";
        WebClient webClient = createWebClient(BASE_URL);

        for (int i = 0; i < 1000; i++) {
            Fact fact = getApiResponse(webClient,"en","random","json");
            uniqueRecords.put(fact.getId(),fact);
        }
    }


    //Here we create the webclient instance. We can configurate the default cookies, headers,etc.
    public static WebClient createWebClient(String url/*,String header o Mapa de headers*/){

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                //crear luego un defaultheader builder o algo asi
                .defaultHeader(HttpHeaders.ACCEPT, "application/json;charset=UTF-8")
                .build();

        return webClient;
    }

    //this part prepares the request, here we can provide the paths (uri), extra headers, methods and a body (for post methods)
    public static Fact getApiResponse(WebClient webClient, String language, String path, String format/*, MediaType mediaType*/){

        Fact response = webClient
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder
                        .path(path+"."+format) //el path nos permite usar codigo mustach
                        .queryParam("language",language)    //Aqui irian los parametros si fuera necesario
                        .build())
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                //This part sends the request and receives the response
                .retrieve()
                .bodyToMono(Fact.class)
                .block();

        return response;
    }

   public int getFactSize(){
       return uniqueRecords.size();
   }

    public boolean getStatus(){
        Boolean isReady = false;
        if (!uniqueRecords.isEmpty()){
            isReady = true;
        }
        return isReady;
    }

    public Set<String> getUniqueId(){
        return uniqueRecords.keySet();
    }

    public Fact getFactById(String id){
        return uniqueRecords.get(id);
    }

    public static String printObject(Fact object){

        ObjectMapper ow = new ObjectMapper();

        ow.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonData = null;

        try {
            jsonData = ow.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonData;
    }


}
