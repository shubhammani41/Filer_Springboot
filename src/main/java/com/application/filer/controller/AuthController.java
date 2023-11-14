package com.application.filer.controller;

import com.application.filer.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/getToken")
    public ResponseEntity<Map<String,Object>> generateToken(@RequestParam String user_name, @RequestParam String user_password){
        return  this.responseService.getSuccessRes(null);
    }
}




