package com.hackadeal.apilivros.controller;

import com.hackadeal.apilivros.entity.LivroEntity;
import com.hackadeal.apilivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livro")
    public ResponseEntity<List<LivroEntity>> getLivros(){
        return new ResponseEntity<> (livroRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/livro/nome/{nome}")
    public ResponseEntity<List<LivroEntity>> getLivroByNome(@PathVariable("nome") String nome){
        return new ResponseEntity<> (livroRepository.findByNome(nome),HttpStatus.OK);
    }

    @GetMapping("/livro/codigo/{codigo}")
    public ResponseEntity<List<LivroEntity>> getLivroByCodigo(@PathVariable("codigo") int codigo){
        return new ResponseEntity<> (livroRepository.findByCodigo(codigo),HttpStatus.OK);
    }

    @GetMapping("/livro/categoria/{categoria}")
    public ResponseEntity<List<LivroEntity>> getLivroByCategoria(@PathVariable("categoria") String categoria){
        return new ResponseEntity<> (livroRepository.findByCategoria(categoria),HttpStatus.OK);
    }

    @GetMapping("/livro/preco/{preco_min}/{preco_max}")
    public ResponseEntity<List<LivroEntity>> getLivroByPrice(@PathVariable("preco_min") int preco_min,
                                             @PathVariable("preco_max") int preco_max){
        return new ResponseEntity<> (livroRepository.getByPrice(preco_min, preco_max),HttpStatus.OK);
    }

}
