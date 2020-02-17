package com.hackadeal.apilivros.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class CategoriaEntity {

    @Id
    private int id;
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<LivroEntity> livros;

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

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
