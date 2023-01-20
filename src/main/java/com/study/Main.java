package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication // 컴포넌트스캔과 인에이블오토컨피궐레이션 대신 쓸수 있음 스프링부트
//@ComponentScan(basePackages = "com.study") 아래이 3개는 스프링 어노테이션
//@EnableAutoConfiguration
//@Configuration
@RestController
@RequestMapping("/api/c1/customers")
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello!");
        SpringApplication.run(Main.class, args);
    }

    public List<Customer> getCustomers() {
        return List.of();
    }
//@GetMapping("/greet")
//    public String greet() {
//        return "Hello";
//    }
    @GetMapping("/greet")
    public GreetResponse greet() {
              GreetResponse response= new GreetResponse(
                      "Hello",
                      List.of("Java", "Golang"),
                      new Person("Alex", 28, 30)
               );
        return response;
    }

    record Person(String name, int age, double savings) {

    }
        record GreetResponse(
                String greet,
                List<String> favProgrammingLanguages,
                Person person
        ) {
    }
    //json으로 받는 방법 아래 쭉
//    class GreetResponse {
//        private final String greet;
//
//        GreetResponse(String greet) {
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return greet.equals(that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }

}
