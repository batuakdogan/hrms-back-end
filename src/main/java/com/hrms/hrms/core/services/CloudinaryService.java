package com.alihocaoglu.hrms.core.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;
    private Map<String,String> valuesMap=new HashMap<>();

    public CloudinaryService(){
        valuesMap.put("cloud_name","dldfibq4u");
        valuesMap.put("api_key", "515178569245171");
        valuesMap.put("api_secret","OrNfDEele1JBl-xyN9YeFW7uCW4");
        cloudinary=new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws IOException{
        File file= convert(multipartFile);
        Map result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException{
        Map result= cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream stream=new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
