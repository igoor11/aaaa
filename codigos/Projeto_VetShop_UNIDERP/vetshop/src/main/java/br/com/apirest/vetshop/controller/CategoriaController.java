package br.com.apirest.vetshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.vetshop.model.Categoria;
import br.com.apirest.vetshop.service.CategoriaServico;

@RestController
@RequestMapping("/api/vetshop/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaServico servico;

    public CategoriaController(CategoriaServico serv){
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        List<Categoria> cp = this.servico.Browse();
        return new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> getById(@PathVariable Long codigo){
        Optional<Categoria> opt = this.servico.Read(codigo);
        if (opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria cp) {
        Categoria cpnew = this.servico.Add(cp);
        return new ResponseEntity<>(cpnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria cp){
        Categoria cpalt = this.servico.Edit(cp);
        if (cpalt != null){
            return new ResponseEntity<>(cpalt, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Categoria> delete(@PathVariable Long codigo){
        Categoria cpdel = this.servico.Delete(codigo);
        if (cpdel != null){
            return new ResponseEntity<>(cpdel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
