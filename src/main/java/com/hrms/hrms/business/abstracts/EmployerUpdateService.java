package com.alihocaoglu.hrms.busines.abstracts;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.entities.concretes.EmployerUpdate;

import java.util.List;

public interface EmployerUpdateService {


    DataResult<List<EmployerUpdate>> getVerifyed();

    public DataResult<List<EmployerUpdate>> getAll();
}
