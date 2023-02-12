package com.softuni.mobilele.repositories;

import com.softuni.mobilele.models.entities.Brand;
import com.softuni.mobilele.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Optional<Model> findFirstByName(String name);
}
