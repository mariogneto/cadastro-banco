package br.com.mgn.cadastrobanco.service;

import br.com.mgn.cadastrobanco.domain.ClienteDTO;
import br.com.mgn.cadastrobanco.domain.EnderecoDTO;
import br.com.mgn.cadastrobanco.domain.Cliente;
import br.com.mgn.cadastrobanco.domain.Endereco;
import br.com.mgn.cadastrobanco.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

/*
    @Test
    void deveCadastrarClienteComSucesso() {
        var salvo = clienteService.criarCliente(
                        new ClienteDTO("12345678900", "João Silva", LocalDate.of(1990, 1, 1), "999999999",
                                new EnderecoDTO("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678")))
                .orElse(null);
        assertNotNull(salvo);
    }
*/

    @Test
    void deveCadastrarClienteComSucesso() {
        var clienteDTO = new ClienteDTO("12345678900", "João Silva", LocalDate.of(1990, 1, 1), "999999999",
                new EnderecoDTO("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678"));

        var cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("João Silva");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        cliente.setTelefone("999999999");
        cliente.setEndereco(new Endereco("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678"));

        assertNotNull(cliente);

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        var salvo = clienteService.criarCliente(clienteDTO).orElse(null);

        assertNotNull(salvo);
    }

}