package com.Andres.Yapily;

import com.Andres.Yapily.entity.Fact;
import com.Andres.Yapily.service.ApiConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.UnsupportedMediaTypeException;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static java.lang.System.out;

@SpringBootApplication
public class YapilyApplication {

	//private static final Logger log = LoggerFactory.getLogger(YapilyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(YapilyApplication.class, args);
	}
/*
	@Autowired
	public ApiConsumer apiConsumer;

	@Bean
	public CommandLineRunner run() {
		return args -> {
			BufferedWriter out = null;
			File tempFile = null;
			Fact fact = null;
			try {
				final String BASE_URL = "https://uselessfacts.jsph.pl/";
                /*dataService.saveFieldData();
                System.out.println("EL PROCESO HA TERMINADO");*/
			/*	WebClient webClient = apiConsumer.createWebClient(BASE_URL);

				/*tempFile = File.createTempFile("prefix-", "-suffix");
				FileWriter fstream = new FileWriter(tempFile,true);
				out = new BufferedWriter(fstream);
				for (int i = 0; i < 1000; i++) {
					fact = apiConsumer.getApiResponse(webClient,"en","random","json");
					out.write(fact.toString());
					out.newLine();

				}*/

				//Won't store duplicated Ids
			/*	Set<Fact> uniqueId = new HashSet<>();
				for (int i = 0; i < 1000; i++) {
					fact = apiConsumer.getApiResponse(webClient,"en","random","json");
					uniqueId.add(fact);

				}
				//String resutado = apiConsumer.printObject(fact);

				log.info(uniqueId.toString());


				/*Fact fact = webClient
						.get()
						.uri("")
						.accept(MediaType.valueOf(MediaType.ALL_VALUE))
						.header(HttpHeaders.ACCEPT, "application/json;charset=UTF-8")
						.retrieve()
						.bodyToMono(Fact.class)
						.block();*/




		/*	} catch (UnsupportedMediaTypeException e) {
				//CUANDO DEVUELVE ESTE ERROR SIGNIFICA QUE LA RESPUESTA DEL SERVIDOR ESTA EN FORMATO HTML(O EL QUE SEA EXCEPTO JSON)
				e.printStackTrace();
			}catch (NullPointerException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(out != null) {
					out.close();
					tempFile.deleteOnExit();
				}
			}
		};
	}*/


}
