package com.alihocaoglu.hrms.busines.concretes;

import com.alihocaoglu.hrms.busines.abstracts.EmployerUpdateService;
import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.SuccessDataResult;
import com.alihocaoglu.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.alihocaoglu.hrms.entities.concretes.EmployerUpdate;
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
