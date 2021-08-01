package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

public interface ActivationByStaffService {
    void createActivationByStaff(Employer employer);
    Result activateEmployer(int employerId,int staffId);
}
