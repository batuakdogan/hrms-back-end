package com.alihocaoglu.hrms.api.controllers;


import com.alihocaoglu.hrms.busines.abstracts.EmployerUpdateService;
import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employerUpdate")
@CrossOrigin
public class EmployerUpdatesController {


    private EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdatesController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("/getverifyed")
    public DataResult<List<EmployerUpdate>> getWaitingUpdate(){
        return this.employerUpdateService.getVerifyed();
    }

    @GetMapping("/getAll")
    public DataResult<List<EmployerUpdate>> getAll(){
        return this.employerUpdateService.getAll();
    }

}
