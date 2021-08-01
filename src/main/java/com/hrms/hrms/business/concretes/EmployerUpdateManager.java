package com.hrms.hrms.busines.concretes;

import com.hrms.hrms.busines.abstracts.EmployerUpdateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.hrms.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

    private EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }


    @Override
    public DataResult<List<EmployerUpdate>> getVerifyed(){
        return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.getVerifyed(),"Başarılı");
    }


    @Override
    public DataResult<List<EmployerUpdate>> getAll(){
        return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.findAll(),"Başarılı");
    }

}
