package poo2.estoque.service;

import java.util.List;
import java.util.Optional;

public interface IBaseServicoJPA<TDominio> {
    List<TDominio> Browse();
    Optional<TDominio> Read(Long chave);
    TDominio Edit(TDominio obj);
    TDominio Add(TDominio obj);
    TDominio Delete(Long chave);
}
