package br.com.apirest.vetshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private String CPF;
    private String email;
    private String telefone;

    public Long getCodigo() {
        return Id;
    }
    public void setCodigo(Long codigo) {
        this.Id = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return this.Id;
    }
    
    public Cliente() {
    }

    public Cliente(Long Id, String nome, String cPF, String email, String telefone) {
        this.Id = Id;
        this.nome = nome;
        CPF = cPF;
        this.email = email;
        this.telefone = telefone;
    }

}
