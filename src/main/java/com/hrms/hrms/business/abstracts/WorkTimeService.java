package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    public DataResult<List<WorkTime>> getAll();
}
