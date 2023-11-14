package com.application.filer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseService {
    public ResponseEntity<Map<String,Object>> getSuccessRes(Object obj){
        Map<String,Object> response = new HashMap<>();
        response.put("data", obj);
        response.put("message","success");
        response.put("error","");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Map<String,Object>> getErrorRes(Exception e){
        Map<String,Object> response = new HashMap<>();
        response.put("data", null);
        response.put("message","error");
        if(e!= null){
            response.put("error",e.getMessage());
        }
        else {
            response.put("error","Internal Server Error");
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
