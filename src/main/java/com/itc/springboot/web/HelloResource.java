package com.itc.springboot.web;

import com.itc.springboot.dto.HelloMessageResponseDTO;
import com.itc.springboot.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    Logger log = LoggerFactory.getLogger(HelloResource.class);

    private GreetingService greetingService;

    public HelloResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //get adalah salah satu jenis dari http method/ http verb
    //POST, PUT, DELETE, OPTION, TRACE, HEAD, PATCH
    @GetMapping("/hello")
    public ResponseEntity<HelloMessageResponseDTO> helloWorld() {
        log.trace("this is log TRACE"); //untuk menampilkan trace dan debug harus memanggilnya lewat application.yml
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
        dto.setMessage(greetingService.sayGreeting());
        return ResponseEntity.accepted().body(dto);
    }
}
