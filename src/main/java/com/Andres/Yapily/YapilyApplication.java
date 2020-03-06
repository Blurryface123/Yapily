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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static java.lang.System.out;

@SpringBootApplication
@EnableSwagger2
public class YapilyApplication {

	//private static final Logger log = LoggerFactory.getLogger(YapilyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(YapilyApplication.class, args);
	}

}
