package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/home")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }

//    record GreetResponse(String greet){}

//    public class GreetResponse {
//        private final  String greet;
//
//            GreetResponse(String greet){
//                this.greet = greet;
//            }
//
//            public String getGreet(){
//                return greet;
//            }
//
//            @Override
//        public String toString(){
//                return "GreetResponse{" +
//                        "greet='" + greet + '\'' + '}';
//            }
//
//    }
}
