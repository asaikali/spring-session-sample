package com.example.greeterjdbcwebmvc;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

  @GetMapping("/")
  public String counter(HttpSession session){

    // this is not thread safe
    Integer counter = (Integer) session.getAttribute("counter");
    if(counter == null) {
      counter = 1;
    } else {
      counter += 1;
    }
    session.setAttribute("counter", counter);
    return "this api has been called " +  counter   + " times";
  }

}
