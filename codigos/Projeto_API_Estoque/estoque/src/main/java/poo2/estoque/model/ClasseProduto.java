package poo2.estoque.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClasseProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    private LocalDate dataDeInclusao;

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    private LocalDate dataDeAlteracao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public ClasseProduto() {
    }

    public ClasseProduto(Long codigo, String descricao, LocalDate dataDeInclusao, LocalDate dataDeAlteracao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
    }

}
