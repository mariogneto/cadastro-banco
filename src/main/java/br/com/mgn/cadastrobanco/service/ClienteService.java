package br.com.mgn.cadastrobanco.service;

import br.com.mgn.cadastrobanco.controller.ClienteDTO;
import br.com.mgn.cadastrobanco.controller.EnderecoDTO;
import br.com.mgn.cadastrobanco.entity.Cliente;
import br.com.mgn.cadastrobanco.entity.Endereco;
import br.com.mgn.cadastrobanco.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.save(mapToEntity(clienteDTO));
        return mapToDTO(cliente);
    }

    public ClienteDTO buscarClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
               // .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return mapToDTO(cliente);
    }

    public ClienteDTO atualizarCliente(String cpf, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
               // .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setEndereco(mapToEntity(clienteDTO.endereco()));

        cliente = clienteRepository.save(cliente);
        return mapToDTO(cliente);
    }


    public void deletarCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
               // .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }

    // Métodos de mapeamento (mapToEntity, mapToDTO)
    private Endereco mapToEntity(@NotNull EnderecoDTO enderecoDTO) {
        return null;
    }
    private Cliente mapToEntity(@NotNull ClienteDTO clienteDTO) {
        return null;
    }
    private ClienteDTO mapToDTO(Cliente cliente) {
        return null;
    }



}