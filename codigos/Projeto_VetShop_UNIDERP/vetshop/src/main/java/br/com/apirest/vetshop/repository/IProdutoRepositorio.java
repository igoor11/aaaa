package br.com.apirest.vetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.vetshop.model.Produto;

public interface IProdutoRepositorio extends JpaRepository<Produto, Long>{
    
}
