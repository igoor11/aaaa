package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Pedido;
import br.com.apirest.vetshop.repository.IPedidoRepositorio;

@Service
public class PedidoServicoJPA implements IBaseServicoJPA<Pedido>{
    
    @Autowired
    IPedidoRepositorio repo;

    public PedidoServicoJPA(IPedidoRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public Pedido Add(Pedido obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Pedido> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Pedido Delete(Long chave) {
        Optional<Pedido> old = this.repo.findById(chave);
        if (old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Pedido Edit(Pedido obj) {
        Optional<Pedido> old = this.repo.findById(obj.getId());
        if (old.isPresent()){
           Pedido cp = old.get();
            cp.setId(obj.getId());
            cp.setNome(obj.getNome());
            cp.setCliente(obj.getCliente());
            cp.setFornecedor(obj.getFornecedor());
            cp.setDataDeAlteracao(obj.getDataDeAlteracao());
            cp.setDataDeInclusao(obj.getDataDeInclusao());
            cp.setItempedido(obj.getItempedido());
            this.repo.save(cp);
            return cp;
        }
        else{
            return null;
        }
    }

    @Override
    public Optional<Pedido> Read(Long chave) {
        return this.repo.findById(chave);
    }
     
}

