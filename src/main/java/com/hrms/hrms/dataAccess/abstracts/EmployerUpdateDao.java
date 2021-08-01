package com.alihocaoglu.hrms.dataAccess.abstracts;

import com.alihocaoglu.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {
=======
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

    @Query("From EmployerUpdate where verifyed = false")
    List<EmployerUpdate> getVerifyed();

>>>>>>> f8b1c0d56f4ec87a76c724066005b9986a748b44
}
