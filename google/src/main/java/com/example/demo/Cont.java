//package com.example.demo;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author bibek
// * @project google
// * @project 05/10/2021 - 7:22 AM
// **/
//@RestController
//public class Cont {
//
//    private Service service;
//
//    public Cont(Service service) {
//        this.service = service;
//    }
//    public ResponseEntity<?> as(@RequestBody Fto f){
//        Fto fto =service.save(f);
//        return ResponseEntity.ok("save"+fto);
//    }
//}
