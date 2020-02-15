package com.hackadeal.apilivros.repository;

import com.hackadeal.apilivros.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity,Integer> {

    @Query(value = "SELECT * FROM livro WHERE nome ILIKE %?1%", nativeQuery = true)
    List<LivroEntity> findByNome(String nome);

    List<LivroEntity> findByCodigo(int codigo);

    @Query(value = "SELECT * FROM livro INNER JOIN categoria ON livro.id_categoria = categoria.id WHERE categoria.nome ILIKE %?1% ", nativeQuery = true)
    List<LivroEntity> findByCategoria(String categoria);

    @Query(value = "SELECT * FROM livro WHERE preco BETWEEN ?1 AND ?2", nativeQuery = true)
    List<LivroEntity> getByPrice(float min, float max);

    List<LivroEntity> findAll();

}
