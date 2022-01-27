package com.example.demolesson4;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "<b>hello</b>";
    }

    public String answerHello(String userName) {
        return "<b>hello</b>" + userName;
    }

}
