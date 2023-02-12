package com.softuni.mobilele.security;

import com.softuni.mobilele.models.enums.RoleType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "guest";

    private String name = ANONYMOUS;

    private boolean isAnonymous = true;

    private List<RoleType> userRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn(){
        return !isAnonymous;
    }

    public boolean isAdmin(){
        return userRoles.contains(RoleType.ADMIN);
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if(anonymous){
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }

    public List<RoleType> getUserRoles() {
        return userRoles;
    }

    public CurrentUser setUserRoles(Set<RoleType> newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }
}
