package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.EmployerUpdate;

import java.util.List;

public interface EmployerUpdateService {


    DataResult<List<EmployerUpdate>> getVerifyed();

    public DataResult<List<EmployerUpdate>> getAll();
}
