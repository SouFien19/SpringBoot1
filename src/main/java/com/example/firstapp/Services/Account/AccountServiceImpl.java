package com.example.firstapp.Services.Account;

import com.example.firstapp.Entity.AppRole;
import com.example.firstapp.Entity.AppUser;
import com.example.firstapp.Repository.Role.AppRoleRepository;
import com.example.firstapp.Repository.User.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {

            throw new RuntimeException("User not found: " + username);
        }

        AppRole appRole = appRoleRepository.findByName(roleName);
        if (appRole == null) {

            throw new RuntimeException("Role not found: " + roleName);
        }

        appUser.getAppRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
