package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff,Integer> {
    Staff findById(int id);
}
