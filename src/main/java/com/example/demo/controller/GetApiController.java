package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(path="/hi",method= RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String Pathname){
        System.out.println("PathVariable : "+Pathname);
        return Pathname;
    }

    //localhost:9091/api/get/query-param
    @PostMapping(path = "query-param")
    public String queryParam(Map<String, String> queryParam) {
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
        });

        return "";
    }
    //localhost:9091/api/get/query-param02
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    //localhost:9091/api/get/query-param03
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
