package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    List<User> findByMailVerifyTrue();
}
