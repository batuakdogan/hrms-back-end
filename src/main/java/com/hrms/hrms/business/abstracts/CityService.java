package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    public DataResult<List<City>> getAll();
}
