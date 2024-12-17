package br.com.mgn.cadastrobanco.service;

import br.com.mgn.cadastrobanco.domain.Cliente;
import br.com.mgn.cadastrobanco.domain.ClienteDTO;
import br.com.mgn.cadastrobanco.domain.Endereco;
import br.com.mgn.cadastrobanco.domain.EnderecoDTO;
import br.com.mgn.cadastrobanco.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void deveAtualizarCadastrarClienteComSucesso() {
        var clienteDTO = new ClienteDTO("12345678900", "João Silva", LocalDate.of(1990, 1, 1), "999999999",
                new EnderecoDTO("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678"));

        var cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("João Silva");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        cliente.setTelefone("999999999");
        cliente.setEndereco(new Endereco("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678"));

        assertNotNull(cliente);

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteRepository.findByCpf(any(String.class))).thenReturn(Optional.of(cliente));

        Optional<ClienteDTO> salvoDTO = clienteService.atualizarCliente("12345678900", clienteDTO);
        assertTrue(salvoDTO.isPresent());

        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    void deveDeletarClienteComSucesso() {
        criarClienteMock();
        clienteService.deletarCliente("12345678900");
        verify(clienteRepository, times(1)).delete(any(Cliente.class));
    }

    private void criarClienteMock() {
        var cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("João Silva");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        cliente.setTelefone("999999999");
        cliente.setEndereco(new Endereco("Rua A", "123", "Bairro X", "Cidade Y", "Estado Z", "12345-678"));
        when(clienteRepository.findByCpf(any(String.class))).thenReturn(Optional.of(cliente));
    }

}