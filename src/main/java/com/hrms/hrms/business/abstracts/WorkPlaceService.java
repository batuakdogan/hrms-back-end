package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkPlace;

import java.util.List;

public interface WorkPlaceService {
    public DataResult<List<WorkPlace>> getAll();
}
