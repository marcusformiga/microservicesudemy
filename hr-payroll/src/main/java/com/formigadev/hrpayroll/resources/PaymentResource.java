package com.formigadev.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formigadev.hrpayroll.entities.Payment;
import com.formigadev.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
  
  @Autowired
  PaymentService paymentService;

  @GetMapping(path = "/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days) {
    Payment payment = this.paymentService.getPayment(workerId, days);
    return ResponseEntity.ok().body(payment);
  }
}
