package com.formigadev.hrworker.resources;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formigadev.hrworker.entities.Worker;
import com.formigadev.hrworker.repositories.WorkerRepo;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

  // TODO: Implementar DTO
  // Usar resileence4j
  // Implementar Logs
  // Utilizar services
  // Fazer testes unitarios
  // implementar mais regras de negocio
  // implementar handle de erros

  @Autowired
  Environment env;
  private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
  @Autowired
  WorkerRepo workerRepo;

  @PostMapping
  public ResponseEntity<Worker> create(@RequestBody Worker dto) {
    Worker saveWorker = this.workerRepo.save(dto);
    return ResponseEntity.created(null).body(saveWorker);
  }
  @GetMapping
  public List<Worker> findAll() {
    List workersList = this.workerRepo.findAll();
    return workersList;
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<Worker> findOne(@PathVariable long id) {
    logger.info("PORT = " + env.getProperty("local.server.port"));
    Worker worker = this.workerRepo.findById(id).get();
    return ResponseEntity.ok().body(worker);
  }
}
