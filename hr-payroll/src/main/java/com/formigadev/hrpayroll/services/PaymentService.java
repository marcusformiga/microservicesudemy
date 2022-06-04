package com.formigadev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formigadev.hrpayroll.client.rest.WorkerFeignCllient;
import com.formigadev.hrpayroll.entities.Payment;
import com.formigadev.hrpayroll.entities.Worker;

// 1- consumir a api de workers para buscar os dados com o restTemplate
// 2- Criar bean do restTemplate (singleton)
@Service
public class PaymentService {
  
  
  @Autowired
  private WorkerFeignCllient workerClient;

  public Payment getPayment(long workerId, int days) {
    // Map<String, String> uriVariables = new HashMap<>();
    // uriVariables.put("id", "" +workerId);
    // Nao pode converter responseEntity em worker por isso o getbody
    Worker worker = workerClient.findOne(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(),days);
  }
}
