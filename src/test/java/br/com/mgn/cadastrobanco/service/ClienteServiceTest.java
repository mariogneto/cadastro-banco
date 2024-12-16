package br.com.mgn.cadastrobanco.service;

import br.com.mgn.cadastrobanco.entity.Cliente;
import br.com.mgn.cadastrobanco.entity.Endereco;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Test
    void deveCadastrarClienteComSucesso() {
        Endereco endereco = new Endereco("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678");
        Cliente cliente = new Cliente(UUID.randomUUID(),"12345678900", "João Silva", LocalDate.of(1990, 1, 1), "999999999", endereco);
        //Cliente salvo = clienteService.salvar(cliente);
        //assertNotNull(salvo);
    }

}