package com.alihocaoglu.hrms.dataAccess.abstracts;

import com.alihocaoglu.hrms.entities.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff,Integer> {
<<<<<<< HEAD
=======
    Staff findById(int id);
>>>>>>> f8b1c0d56f4ec87a76c724066005b9986a748b44
}
