package com.application.filer.service;


import com.application.filer.dao.User_Mst_Repo;
import com.application.filer.dto.User_Mst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final User_Mst_Repo userMstRepo;

    @Autowired
    public UserService(User_Mst_Repo userMstRepo) {
        this.userMstRepo = userMstRepo;
    }
    public List<User_Mst> getUserList(){
        return this.userMstRepo.findAll();
    }

    public void saveUser(User_Mst user){
        this.userMstRepo.save(user);
    }

    public Optional<User_Mst> getUser(String user_id){
        Long userIdLong = Long.valueOf(user_id);
        return this.userMstRepo.findById(userIdLong);
    }
}
