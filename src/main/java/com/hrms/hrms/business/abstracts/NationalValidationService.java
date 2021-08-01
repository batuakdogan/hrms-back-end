package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;

public interface NationalValidationService {
    boolean validate(Candidate candidate);
}
