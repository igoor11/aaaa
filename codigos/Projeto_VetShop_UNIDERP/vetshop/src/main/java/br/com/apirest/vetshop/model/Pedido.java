package br.com.apirest.vetshop.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id") 
    private Set<ItemPedido> itempedido;   
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id") 
    private Fornecedor fornecedor;  

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente;  

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    private LocalDate DataDeInclusao;

    @DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
    private LocalDate DataDeAlteracao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ItemPedido> getItempedido() {
        return itempedido;
    }

    public void setItempedido(Set<ItemPedido> itempedido) {
        this.itempedido = itempedido;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataDeInclusao() {
        return DataDeInclusao;
    }

    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        DataDeInclusao = dataDeInclusao;
    }

    public LocalDate getDataDeAlteracao() {
        return DataDeAlteracao;
    }

    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        DataDeAlteracao = dataDeAlteracao;
    }

    public Pedido() {
    }

    public Pedido(Long id, String nome, Set<ItemPedido> itempedido, Fornecedor fornecedor, Cliente cliente,
            LocalDate dataDeInclusao, LocalDate dataDeAlteracao) {
        Id = id;
        this.nome = nome;
        this.itempedido = itempedido;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        DataDeInclusao = dataDeInclusao;
        DataDeAlteracao = dataDeAlteracao;
    }
}
