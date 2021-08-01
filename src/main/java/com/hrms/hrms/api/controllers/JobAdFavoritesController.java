package com.hrms.hrms.api.controllers;

import com.hrms.hrms.busines.abstracts.JobAdFavoritesService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobAdFavorites")
@CrossOrigin
public class JobAdFavoritesController {

    private JobAdFavoritesService jobAdFavoritesService;

    @Autowired
    public JobAdFavoritesController(JobAdFavoritesService jobAdFavoritesService) {
        this.jobAdFavoritesService = jobAdFavoritesService;
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        DataResult<List<JobAdFavorites>> result=this.jobAdFavoritesService.getByCandidateId(candidateId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/addFavorite")
    public ResponseEntity<?> addFavorite(@RequestParam int candidateId,@RequestParam int jobAdId){
        Result result=this.jobAdFavoritesService.addFavorite(candidateId,jobAdId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/removeFavorite")
    public ResponseEntity<?> removeFavorite(@RequestParam int favoriteId){
        Result result = this.jobAdFavoritesService.removeFavorite(favoriteId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
