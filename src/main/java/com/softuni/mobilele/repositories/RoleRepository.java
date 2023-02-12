package com.softuni.mobilele.repositories;

import com.softuni.mobilele.models.entities.Role;
import com.softuni.mobilele.models.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRole(RoleType String);
}
