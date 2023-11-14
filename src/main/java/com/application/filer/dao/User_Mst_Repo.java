package com.application.filer.dao;

import com.application.filer.dto.User_Mst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Mst_Repo extends JpaRepository<User_Mst,Long> {
}
