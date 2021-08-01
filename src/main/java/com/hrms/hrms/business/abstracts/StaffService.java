package com.alihocaoglu.hrms.busines.abstracts;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.Result;
import com.alihocaoglu.hrms.entities.concretes.Staff;
import com.alihocaoglu.hrms.entities.dtos.StaffUpdateDto;

import java.util.List;

public interface StaffService {
    public Result create(Staff staff);
    public DataResult<List<Staff>> getAll();
    public Result update(StaffUpdateDto staffUpdateDto);
<<<<<<< HEAD
=======
    DataResult<Staff> findById(int id);
>>>>>>> f8b1c0d56f4ec87a76c724066005b9986a748b44
}
