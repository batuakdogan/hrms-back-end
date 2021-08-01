package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.entities.concretes.User;

public interface EmailService {
    void sendVerifyEmail(User user,String code);
}
