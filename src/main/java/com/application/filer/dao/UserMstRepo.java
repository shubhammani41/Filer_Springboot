package com.application.filer.dao;

import com.application.filer.dto.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMstRepo extends JpaRepository<UserMst,Long> {
}
