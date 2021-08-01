package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Staff;
import com.hrms.hrms.entities.dtos.StaffUpdateDto;

import java.util.List;

public interface StaffService {
    public Result create(Staff staff);
    public DataResult<List<Staff>> getAll();
    public Result update(StaffUpdateDto staffUpdateDto);
    DataResult<Staff> findById(int id);
}
