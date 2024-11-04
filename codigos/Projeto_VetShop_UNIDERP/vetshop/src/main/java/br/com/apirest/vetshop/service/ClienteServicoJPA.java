package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Cliente;
import br.com.apirest.vetshop.repository.IClienteRepositorio;

@Service
public class ClienteServicoJPA implements IBaseServicoJPA<Cliente>{
    
    @Autowired
    IClienteRepositorio repo;

    public ClienteServicoJPA(IClienteRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public Cliente Add(Cliente obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Cliente> Browse() {
        return this.repo.findAll();
    }

    @Override
    public Cliente Delete(Long chave) {
        Optional<Cliente> old = this.repo.findById(chave);
        if (old.isPresent()){
            this.repo.delete(old.get());
            return old.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Cliente Edit(Cliente obj) {
        Optional<Cliente> old = this.repo.findById(obj.getId());
        if (old.isPresent()){
            Cliente cp = old.get();
            cp.setNome(obj.getNome());
            cp.setCPF(obj.getCPF());
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
    public Optional<Cliente> Read(Long chave) {
        return this.repo.findById(chave);
    }
     
}
