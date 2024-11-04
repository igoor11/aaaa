package br.com.apirest.vetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.vetshop.model.Fornecedor;

public interface IFornecedorRepositorio extends JpaRepository<Fornecedor, Long>{
    
}
