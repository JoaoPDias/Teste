package com.main.models;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class ActivityArea {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o Nome")
    private String nome;

    @Override
    public String toString() {
        return "ActivityArea{" +
                "id=" + id +
                ", nome='" + nome +
                '}';
    }

    public ActivityArea() {
    }

    public ActivityArea(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
