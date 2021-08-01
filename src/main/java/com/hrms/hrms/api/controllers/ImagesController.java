package com.hrms.hrms.api.controllers;

import com.hrms.hrms.busines.abstracts.ImageService;
import com.hrms.hrms.core.services.CloudinaryService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.dataAccess.abstracts.CvDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private CloudinaryService cloudinaryService;
    private ImageService imageService;
    private CvDao cvDao;

    @Autowired
    public ImagesController(CloudinaryService cloudinaryService, ImageService imageService,CvDao cvDao) {
        this.cloudinaryService = cloudinaryService;
        this.imageService = imageService;
        this.cvDao=cvDao;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.imageService.getAll());
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile ,@RequestParam int cvId){
        Result result=this.imageService.update(multipartFile,cvId);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        Result result=this.imageService.delete(id);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
