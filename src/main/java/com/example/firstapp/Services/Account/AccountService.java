package com.example.firstapp.Services.Account;

import com.example.firstapp.Entity.AppRole;
import com.example.firstapp.Entity.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
