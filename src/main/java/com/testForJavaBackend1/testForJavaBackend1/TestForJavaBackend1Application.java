package com.testForJavaBackend1.testForJavaBackend1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TestForJavaBackend1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestForJavaBackend1Application.class, args);
	}

	@Bean
	WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1")
				.build();
		return webClient;
	}
}
