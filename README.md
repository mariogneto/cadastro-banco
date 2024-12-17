Estrutura Geral


Tecnologias a serem utilizadas:
Framework: Spring Boot.

Banco de Dados: PostgreSQL ou MongoDB.
Resiliência: Resilience4J.

Testes: JUnit.
Documentação: Swagger/OpenAPI.

Arquitetura:
Hexagonal (Ports and Adapters):

Separar as responsabilidades em camadas:

Domínio: Regras de negócio.

Aplicação: Orquestração e lógica de uso.

Infraestrutura: Conexões externas (Banco, APIs, etc.).

APIs a serem criadas:

API de Cadastro: CRUD completo (criação, leitura, atualização, deleção).

API de Seguros:

Simulação de seguros (consulta baseada no cliente e tipo de seguro).

Contratação do seguro (verificando a existência do cliente via API de Cadastro).

Detalhamento das Funcionalidades


API de Cadastro

Responsável por gerenciar os clientes.


Endpoints:
POST /clientes: Criação de um novo cliente.

GET /clientes/{cpf}: Consultar cliente por CPF.

PUT /clientes/{cpf}: Atualizar informações do cliente.

DELETE /clientes/{cpf}: Remover cliente.


Validações importantes:
CPF deve ser único e validado no momento do cadastro.

Todos os campos obrigatórios devem ser validados.

Modelo de Dados (Cliente):

public class Cliente {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private Endereco endereco;
}

public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}

API SWAGGER

http://localhost:8080/swagger-ui/index.html

