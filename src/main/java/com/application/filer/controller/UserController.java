package com.application.filer.controller;

import com.application.filer.dto.UserMst;
import com.application.filer.service.ResponseService;
import com.application.filer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("/getUserList")
    public ResponseEntity<Map<String, Object>> getUserList(){
        try{
            List<UserMst> userList = this.userService.getUserList();
            return this.responseService.getSuccessRes(userList);
        }
        catch (Exception e){
            return this.responseService.getErrorRes(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserMst user){
        try{
            this.userService.saveUser(user);
            return this.responseService.getSuccessRes(null);
        }
        catch (Exception e){
            return this.responseService.getErrorRes(e);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<Map<String,Object>> getUserbyId(@RequestParam String user_id){
        try{
            Optional<UserMst> user = this.userService.getUserById(user_id);
            return this.responseService.getSuccessRes(user);
        }
        catch(Exception e){
            return this.responseService.getErrorRes(e);
        }
    }
}



