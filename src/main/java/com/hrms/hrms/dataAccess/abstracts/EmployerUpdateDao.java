package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

    @Query("From EmployerUpdate where verifyed = false")
    List<EmployerUpdate> getVerifyed();

}
