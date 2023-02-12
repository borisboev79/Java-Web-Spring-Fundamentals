package com.softuni.mobilele.services.user;

import com.softuni.mobilele.services.init.DataBaseInitServiceService;

public interface UserService extends DataBaseInitServiceService {
    boolean authenticate(String username, String password);

    void loginUsername(String username);

    void logoutCurrentUser();
}
