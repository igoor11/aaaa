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

import br.com.apirest.vetshop.model.Pedido;
import br.com.apirest.vetshop.service.PedidoServicoJPA;


@RestController
@RequestMapping("/api/vetshop/pedido")
public class PedidoController {
    @Autowired
    private PedidoServicoJPA servico;

     public PedidoController(PedidoServicoJPA serv){
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        List<Pedido> cp = this.servico.Browse();
        return new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getById(@PathVariable Long codigo){
        Optional<Pedido> opt = this.servico.Read(codigo);
        if (opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody Pedido cp) {
        Pedido cpnew = this.servico.Add(cp);
        return new ResponseEntity<>(cpnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pedido> put(@RequestBody Pedido cp){
        Pedido cpalt = this.servico.Edit(cp);
        if (cpalt != null){
            return new ResponseEntity<>(cpalt, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pedido> delete(@PathVariable Long codigo){
        Pedido cpdel = this.servico.Delete(codigo);
        if (cpdel != null){
            return new ResponseEntity<>(cpdel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
