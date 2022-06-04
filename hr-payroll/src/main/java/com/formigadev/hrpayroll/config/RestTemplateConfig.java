package com.formigadev.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
  // singleton restTemplate para ser injetado
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
