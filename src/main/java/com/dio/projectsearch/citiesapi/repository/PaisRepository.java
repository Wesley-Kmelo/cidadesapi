package com.dio.projectsearch.citiesapi.repository;

import com.dio.projectsearch.citiesapi.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository <Pais, Long> {
}

