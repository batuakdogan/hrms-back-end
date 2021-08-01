package com.hrms.hrms.busines.abstracts;


import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Experiance;
import com.hrms.hrms.entities.dtos.ExperianceForSetDto;

import java.util.List;

public interface ExperianceService{
    Result add(ExperianceForSetDto experianceForSetDto);
    Result delete(int experianceId);
    DataResult<List<Experiance>> getByCvId(int id);
}
