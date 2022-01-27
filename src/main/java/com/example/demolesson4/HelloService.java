package com.example.demolesson4;

import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {
    String hello();
    String answerHello(String userName);
}
