package com.Andres.Yapily.service;

import com.Andres.Yapily.entity.Fact;
import com.Andres.Yapily.entity.Translation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.ZonedDateTime;
import java.util.*;
import static com.Andres.Yapily.constants.Constants.BASE_URL;
import static com.Andres.Yapily.constants.Constants.YANDEX_API;

@Service
public class ApiConsumer {

    public static final Map<String,Fact> uniqueRecords = new HashMap();

    static {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("language","en");
        WebClient webClient = createWebClient(BASE_URL);

        for (int i = 0; i < 1000; i++) {
            Fact fact = getFactResponse(webClient,params,"random","json");
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
    public static Fact getFactResponse(WebClient webClient, MultiValueMap params, String path, String format/*, MediaType mediaType*/){

        Fact response = webClient
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder
                        .path(path+"."+format) //el path nos permite usar codigo mustach
                        .queryParams(params)    //Aqui irian los parametros si fuera necesario
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

    public static Translation getTranslationResponse(WebClient webClient, MultiValueMap params, String format, String path/*, MediaType mediaType*/){

        Translation response = webClient
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder
                        .path("."+format+"/"+path) //el path nos permite usar codigo mustach
                        .queryParams(params)    //Aqui irian los parametros si fuera necesario
                        .build())
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                //This part sends the request and receives the response
                .retrieve()
                .bodyToMono(Translation.class)
                .block();

        return response;
    }

    public String translate(String key, List<String> text, String language){
        WebClient webClient = createWebClient(YANDEX_API);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key",key);
        params.addAll("text", text);
        params.add("lang",language);
        Translation translatedText = getTranslationResponse(webClient,params,"json","translate");
        return translatedText.getText().toString();
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


}
