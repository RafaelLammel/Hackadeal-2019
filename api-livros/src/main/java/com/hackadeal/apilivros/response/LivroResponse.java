package com.hackadeal.apilivros.response;

import com.hackadeal.apilivros.entity.CategoriaEntity;
import com.hackadeal.apilivros.entity.LivroEntity;

public class LivroResponse {

    private int id;
    private String nome;
    private float preco;
    private int paginas;
    private int codigo;
    private int id_categoria;
    private String categoria;

    public LivroResponse(LivroEntity livro, CategoriaEntity categoria){
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.codigo = livro.getCodigo();
        this.id_categoria = livro.getId_categoria();
        this.categoria = categoria.getNome();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "LivroResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", codigo=" + codigo +
                ", id_categoria=" + id_categoria +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
