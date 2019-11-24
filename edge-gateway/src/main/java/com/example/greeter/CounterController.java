package com.example.greeter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@RestController
public class CounterController {

  @GetMapping("/")
  public Mono<String> counter(WebSession session){

    // this is not thread safe
    Integer counter = (Integer) session.getAttributeOrDefault("counter",0);
    counter =  counter + 1;
    session.getAttributes().put("counter",counter);
    return Mono.just("this api has been called " +  counter   + " times");
  }

}
