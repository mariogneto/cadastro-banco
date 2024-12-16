package br.com.mgn.cadastrobanco.service;

import br.com.mgn.cadastrobanco.controller.dto.ClienteDTO;
import br.com.mgn.cadastrobanco.controller.dto.EnderecoDTO;
import br.com.mgn.cadastrobanco.entity.Cliente;
import br.com.mgn.cadastrobanco.entity.Endereco;
import br.com.mgn.cadastrobanco.repository.ClienteRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

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
        var endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setCep(enderecoDTO.cep());
        return endereco;
    }

    private Cliente mapToEntity(@NotNull ClienteDTO clienteDTO) {
        var cliente = new Cliente();
        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setEndereco(mapToEntity(clienteDTO.endereco()));
        return cliente;
    }

    private ClienteDTO mapToDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getDataNascimento(), cliente.getTelefone(), mapToDTO(cliente.getEndereco()));
    }

    private EnderecoDTO mapToDTO(Endereco endereco) {
        return new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

}