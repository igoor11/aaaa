package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Produto;
import br.com.apirest.vetshop.repository.IProdutoRepositorio;

@Service
public class ProdutoServico implements IBaseServicoJPA<Produto> {

    @Autowired
    private IProdutoRepositorio repositorio;

    public ProdutoServico(IProdutoRepositorio repo){
        this.repositorio = repo;
    }

    @Override
    public List<Produto> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Produto> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Produto Edit(Produto obj) {
        Optional<Produto> old = this.repositorio.findById(obj.getId());
        if (old.isPresent()){
            Produto cp = old.get();
            cp.setNome(obj.getNome());
            cp.setPreco(obj.getPreco());            
            this.repositorio.save(cp);
            return cp;
        }
        else{
            return null;
        }
    }

    @Override
    public Produto Add(Produto obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Produto Delete(Long chave) {
        Optional<Produto> old = this.repositorio.findById(chave);
        if (old.isPresent()){
            this.repositorio.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }
}
