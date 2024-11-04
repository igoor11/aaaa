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

import br.com.apirest.vetshop.model.Cliente;
import br.com.apirest.vetshop.service.ClienteServicoJPA;

@RestController
@RequestMapping("/api/vetshop/clientes")
public class ClienteController {
    @Autowired
    private ClienteServicoJPA servico;

    public ClienteController(ClienteServicoJPA serv){
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> cp = this.servico.Browse();
        return new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getById(@PathVariable Long codigo){
        Optional<Cliente> opt = this.servico.Read(codigo);
        if (opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente cp) {
        Cliente cpnew = this.servico.Add(cp);
        return new ResponseEntity<>(cpnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> put(@RequestBody Cliente cp){
        Cliente cpalt = this.servico.Edit(cp);
        if (cpalt != null){
            return new ResponseEntity<>(cpalt, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Cliente> delete(@PathVariable Long codigo){
        Cliente cpdel = this.servico.Delete(codigo);
        if (cpdel != null){
            return new ResponseEntity<>(cpdel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

