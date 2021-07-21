package com.airtel.ytl;

import com.airtel.ytl.dto.HealthResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class YtlApplication {

	public static void main(String[] args) {
		System.out.println( "YTL Application is running now" );
		SpringApplication.run(YtlApplication.class, args);
	}

}



