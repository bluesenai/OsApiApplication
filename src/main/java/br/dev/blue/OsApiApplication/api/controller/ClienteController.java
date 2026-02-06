package br.dev.blue.OsApiApplication.api.controller;

import br.dev.blue.OsApiApplication.domain.model.Cliente;
import br.dev.blue.OsApiApplication.domain.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listas() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteID,
                                             @RequestBody Cliente cliente) {

        if (clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteID);
        cliente= clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {

        return clienteRepository.save(cliente);
    }
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir (@PathVariable Long clienteID) {
        
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteID);
        return ResponseEntity.noContent().build();
    }
}
