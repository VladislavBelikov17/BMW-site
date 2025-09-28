package com.mySite.MyJavaSite.Service;

import com.mySite.MyJavaSite.models.UserModel;
import com.mySite.MyJavaSite.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserModel userModel;
    @Autowired
    public UserService(UserModel userModel) {
        this.userModel = userModel;
    }

    public Users saveUser(Users users) {
        return userModel.save(users);
    }
}
