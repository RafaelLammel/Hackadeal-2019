package com.hackadeal.apilivros.controller;

import com.hackadeal.apilivros.entity.CategoriaEntity;
import com.hackadeal.apilivros.entity.LivroEntity;
import com.hackadeal.apilivros.repository.CategoriaRepository;
import com.hackadeal.apilivros.repository.LivroRepository;
import com.hackadeal.apilivros.response.LivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/livro")
    public List<LivroResponse> getLivros(){
        List<LivroEntity> listLivros = livroRepository.findAll();
        return mapCategorias(listLivros);
    }

    @GetMapping("/livro/nome/{nome}")
    public List<LivroResponse> getLivroByNome(@PathVariable("nome") String nome){
        List<LivroEntity> listLivros = livroRepository.findByNome(nome);
        return mapCategorias(listLivros);
    }

    @GetMapping("/livro/codigo/{codigo}")
    public List<LivroResponse> getLivroByCodigo(@PathVariable("codigo") int codigo){
        List<LivroEntity> listLivros = livroRepository.findByCodigo(codigo);
        return mapCategorias(listLivros);
    }

    @GetMapping("/livro/categoria/{categoria}")
    public List<LivroResponse> getLivroByCategoria(@PathVariable("categoria") String categoria){
        List<LivroEntity> listLivros = livroRepository.findByCategoria(categoria);
        return mapCategorias(listLivros);
    }

    @GetMapping("/livro/preco/{preco_min}/{preco_max}")
    public List<LivroResponse> getLivroByPrice(@PathVariable("preco_min") int preco_min,
                                             @PathVariable("preco_max") int preco_max){
        List<LivroEntity> listLivros = livroRepository.getByPrice(preco_min, preco_max);
        return mapCategorias(listLivros);
    }

    private List<LivroResponse> mapCategorias(List<LivroEntity> listLivros){
        List<CategoriaEntity> listCategorias = categoriaRepository.findAll();
        List<LivroResponse> listResponse = new ArrayList<>();
        for (LivroEntity livro : listLivros ) {
            for (CategoriaEntity categoria : listCategorias) {
                if(categoria.getId() == livro.getId_categoria())
                    listResponse.add(new LivroResponse(livro, categoria));
            }
        }
        return listResponse;
    }

}
