package poo2.estoque.fakedb;

import java.util.ArrayList;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseFakeDB<TDominio> {
    protected ArrayList<TDominio> lista;

    public ArrayList<TDominio> getLista(){
        return this.lista;
    }

    protected abstract void preencherLista();

    public BaseFakeDB(){
        this.preencherLista();
    }
}