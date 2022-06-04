package com.formigadev.hrpayroll.client.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formigadev.hrpayroll.entities.Worker;

// na classe principal habilitar o feignclient
// interface feign para as chamadas rest
// a assinatura do metodo é igual ao endpoint que queremos acessar
@Component
@FeignClient(name= "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignCllient {

  @GetMapping(path = "{id}")
  public ResponseEntity<Worker> findOne(@PathVariable long id);

}
