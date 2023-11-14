package com.application.filer.service;


import com.application.filer.dao.UserMstRepo;
import com.application.filer.dto.UserMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserMstRepo userMstRepo;

    @Autowired
    public UserService(UserMstRepo userMstRepo) {
        this.userMstRepo = userMstRepo;
    }
    public List<UserMst> getUserList(){
        return this.userMstRepo.findAll();
    }

    public void saveUser(UserMst user){
        this.userMstRepo.save(user);
    }

    public Optional<UserMst> getUserById(String user_id){
        Long userIdLong = Long.valueOf(user_id);
        return this.userMstRepo.findById(userIdLong);
    }
}
