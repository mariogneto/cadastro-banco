package br.com.mgn.cadastrobanco.controller;

import br.com.mgn.cadastrobanco.controller.dto.ClienteDTO;
import br.com.mgn.cadastrobanco.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.criarCliente(clienteDTO)
                .map(input -> ResponseEntity.status(HttpStatus.CREATED).body(input))
                .orElseGet(() -> ResponseEntity.unprocessableEntity().build());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable String cpf, @RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.atualizarCliente(cpf, clienteDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String cpf) {
        clienteService.deletarCliente(cpf);
        return ResponseEntity.noContent().build();
    }
}
