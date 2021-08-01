package com.hrms.hrms.busines.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.User;
import com.hrms.hrms.entities.dtos.UserLoginDto;
import com.hrms.hrms.entities.dtos.UserLoginReturnDto;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
    DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
    DataResult<List<User>> getVerifyedUsers();
}
