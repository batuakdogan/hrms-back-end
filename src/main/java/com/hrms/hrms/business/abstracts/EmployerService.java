package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;
import com.hrms.hrms.entities.concretes.EmployerUpdate;
import com.hrms.hrms.entities.dtos.EmployerForRegisterDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getByEmail(String email);
    Result add(EmployerForRegisterDto employerDto);
    DataResult<Employer> getById(int id);
    Result update(EmployerUpdate employerUpdate);
    Result verifyUpdate(int employerUpdateId,int staffId);
}
