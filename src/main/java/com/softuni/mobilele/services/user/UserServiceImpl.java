package com.softuni.mobilele.services.user;

import com.softuni.mobilele.models.entities.Role;
import com.softuni.mobilele.models.entities.User;
import com.softuni.mobilele.models.enums.RoleType;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.security.CurrentUser;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, DataBaseInitServiceService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder encoder;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CurrentUser currentUser, PasswordEncoder encoder, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.currentUser = currentUser;
        this.encoder = encoder;

        this.mapper = mapper;
    }


    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> user = this.userRepository.findFirstByUsername(username);

        if (user.isEmpty()) {
            return false;
        } else {
            return encoder.matches(password, user.get().getPassword());
        }
    }

    @Override
    public void loginUsername(String username) {

        User user = userRepository.findFirstByUsername(username).orElseThrow();

        Set<RoleType> userRoles = user.getRoles()
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());

        this.currentUser
                .setAnonymous(false)
                .setName(user.getUsername())
                .setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }


    @Override
    public void dbInit() {
        if (!isDbInit()) {

            List<User> userEntities = new ArrayList<>();
            User admin = new User().setUsername("boboev")
                    .setPassword(encoder.encode("password"))
                    .setActive(true)
                    .setFirstName("Boris")
                    .setLastName("Boev")
                    .setImageUrl("https://cache2.24chasa.bg/Images/Cache/512/Image_7317512_40_0.jpg")
                    .setRoles(Set.of(roleRepository.findRoleByRole(RoleType.ADMIN), roleRepository.findRoleByRole(RoleType.USER)));

            userEntities.add(admin);

            User pesho = new User().setUsername("pesho")
                    .setPassword(encoder.encode("topsecret"))
                    .setActive(true)
                    .setFirstName("Петър")
                    .setLastName("Черноземски")
                    .setImageUrl("https://photo-forum.net/static/site_pics/2011-09/5_1315603342.jpg")
                    .setRoles(Set.of(roleRepository.findRoleByRole(RoleType.USER)));
            userEntities.add(pesho);


            this.userRepository.saveAllAndFlush(userEntities);
        }
    }


    @Override
    public boolean isDbInit() {
        return this.userRepository.count() > 0;
    }

}
