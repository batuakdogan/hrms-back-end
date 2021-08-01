package com.hrms.hrms.busines.concretes;

import com.hrms.hrms.busines.abstracts.NationalValidationService;
import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements NationalValidationService {


    @Override
    public boolean validate(Candidate candidate) {
        if(candidate.getNationalNumber().length()!=11){
            return false;
        }
        return true;
    }
}
