package br.com.apirest.vetshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String RazaoSocial;
    private String NomeFantasia;
    private String CNPJ;
    private String Email;
    private String Telefone;
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getRazaoSocial() {
        return RazaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }
    public String getNomeFantasia() {
        return NomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        NomeFantasia = nomeFantasia;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
    public Fornecedor() {
    }
    public Fornecedor(Long id, String razaoSocial, String nomeFantasia, String cNPJ, String email, String telefone) {
        Id = id;
        RazaoSocial = razaoSocial;
        NomeFantasia = nomeFantasia;
        CNPJ = cNPJ;
        Email = email;
        Telefone = telefone;
    }
}
