package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Fornecedor;
import br.com.apirest.vetshop.repository.IFornecedorRepositorio;

@Service
public class FornecedorServicoJPA implements IBaseServicoJPA<Fornecedor>{
    
    @Autowired
    IFornecedorRepositorio repo;

    public FornecedorServicoJPA(IFornecedorRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public Fornecedor Add(Fornecedor obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Fornecedor> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Fornecedor Delete(Long chave) {
        Optional<Fornecedor> old = this.repo.findById(chave);
        if (old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Fornecedor Edit(Fornecedor obj) {
        Optional<Fornecedor> old = this.repo.findById(obj.getId());
        if (old.isPresent()){
           Fornecedor cp = old.get();
            cp.setId(obj.getId());
            cp.setRazaoSocial(obj.getRazaoSocial());
            cp.setNomeFantasia(obj.getNomeFantasia());
            cp.setCNPJ(obj.getCNPJ());
            cp.setEmail(obj.getEmail());
            cp.setTelefone(obj.getTelefone());
            this.repo.save(cp);
            return cp;
        }
        else{
            return null;
        }
    }

    @Override
    public Optional<Fornecedor> Read(Long chave) {
        return this.repo.findById(chave);
    }
     
}