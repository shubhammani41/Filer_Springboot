package com.application.filer.controller;

import com.application.filer.dto.UserMst;
import com.application.filer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public ResponseEntity<Map<String, Object>> getUserList(){
        Map<String, Object> response = new HashMap<>();
        try{
            List<UserMst> userList = this.userService.getUserList();
            response.put("data",userList);
            response.put("message","success");
            response.put("error","");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            response.put("data", Collections.emptyList());
            response.put("message","error");
            response.put("error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserMst user){
        Map<String, Object> response = new HashMap<>();
        try{
            this.userService.saveUser(user);
            response.put("data", null);
            response.put("message","success");
            response.put("error","");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            response.put("data", Collections.emptyList());
            response.put("message","error");
            response.put("error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<Map<String,Object>> getUserbyId(@RequestParam String user_id){
        Map<String,Object> response = new HashMap<>();
        try{
            Optional<UserMst> user = this.userService.getUserById(user_id);
            response.put("data", user);
            response.put("message","success");
            response.put("error","");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            response.put("data", null);
            response.put("message","error");
            response.put("error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



