package br.com.mgn.cadastrobanco.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(@NotBlank String cpf, @NotBlank String nome, @NotNull LocalDate dataNascimento, @NotBlank String telefone, @NotNull EnderecoDTO endereco) {}
