package com.hackadeal.apilivros.repository;

import com.hackadeal.apilivros.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {

    List<CategoriaEntity> findAll();

}
