package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Categoria;
import br.com.apirest.vetshop.repository.ICategoriaRepositorio;

@Service
public class CategoriaServico implements IBaseServicoJPA<Categoria> {

    @Autowired
    private ICategoriaRepositorio repositorio;

    public CategoriaServico(ICategoriaRepositorio repo){
        this.repositorio = repo;
    }

    @Override
    public List<Categoria> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Categoria> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Categoria Edit(Categoria obj) {
        Optional<Categoria> old = this.repositorio.findById(obj.getId());
        if (old.isPresent()){
            Categoria cat = old.get();
            cat.setNome(obj.getNome());
            this.repositorio.save(cat);
            return cat;
        }
        else{
            return null;
        }
    }

    @Override
    public Categoria Add(Categoria obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Categoria Delete(Long chave) {
        Optional<Categoria> old = this.repositorio.findById(chave);
        if (old.isPresent()){
            this.repositorio.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }
}
