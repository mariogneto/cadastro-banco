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
        ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable String cpf) {
        ClienteDTO cliente = clienteService.buscarClientePorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable String cpf, @RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(cpf, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String cpf) {
        clienteService.deletarCliente(cpf);
        return ResponseEntity.noContent().build();
    }
}

