package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.dtos.CandidateForRegisterDto;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getByNationalNumber(String nationalNumber);
    DataResult<Candidate> getByEmail(String email);
    Result add(CandidateForRegisterDto candidateForRegisterDto);
    DataResult<List<Candidate>> getMailVerifyTrue();
}
