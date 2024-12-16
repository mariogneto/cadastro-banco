package br.com.mgn.cadastrobanco.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(@NotBlank String logradouro, @NotBlank String numero, @NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep) {}