package br.dev.blue.OsApiApplication.api.controller;

import br.dev.blue.OsApiApplication.domain.model.Cliente;
import br.dev.blue.OsApiApplication.domain.repository.ClienteRepository;
import br.dev.blue.OsApiApplication.domain.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    
    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
@ApiResponses(value = {
 @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
 @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
 })
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        return clienteRepository.findAll();
    }
      @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
@ApiResponses(value = {
 @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
 @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
 })
    

    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cliente.get());
        }
        
    }
          @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
@ApiResponses(value = {
 @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
 @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
 })
        

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

        return clienteService.salvar(cliente);
    }
    
      @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
@ApiResponses(value = {
 @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
 @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
 })
    
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar (@Valid @PathVariable Long clienteID, 
                                                     @RequestBody Cliente cliente) {
        
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteID);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }
    
      @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
@ApiResponses(value = {
 @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
 @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
 })
       @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID) {

        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }

        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
        
    }
}