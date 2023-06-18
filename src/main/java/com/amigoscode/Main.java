package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }

    @PostMapping("/api/v1/users")
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer cust = new Customer();
        cust.setName(request.name());
        cust.setAge(request.age());
        cust.setEmail(request.email());
        customerRepository.save(cust);
    }

    @GetMapping("/api/v1/users")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @DeleteMapping("/api/v1/user/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById((id));
    }


    @GetMapping("/home")
    public GreetResponse greet() {

        GreetResponse response = new GreetResponse(
                "hello",
                List.of("Java", "C++", "Python"),
                new Person("Alex")
        );


        return response;
    }

    record Person(String name) {

    }

    record GreetResponse(String greet,
                         List<String> favProgrammingLanguages,
                         Person person) {

    }


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
