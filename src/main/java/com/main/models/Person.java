package com.main.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Person {

    @Id
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o Nome")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Preencha a Matrícula")
    private String matricula;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Preencha o e-mail")
    private String email;

    @Column(nullable = false, name = "dt_nascimento")
    @NotNull(message = "Informa data de nascimento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dtNascimento;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
                ", dt_nascimento=" + dtNascimento +
                '}';
    }

    public Person() {
    }

    public Person(String nome, String matricula, String email, Date dtNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.dtNascimento = dtNascimento;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
