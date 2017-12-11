# Bank Cash - Saque de Notas

Este projeto tem como intuito criar um aplicação web que simule a entrega de notas quando um 
cliente efetua um saque em um caixa eletrônico.

Requisitos básicos:
Entregar o menor número de notas;
É possível sacar o valor solicitado com as notas disponíveis; Saldo do cliente será cadastrado; 
Quantidade de notas infinito Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00 
O Cliente não poderá entrar no negativo

### Objetivo
* Criar a aplicação com seus requisitos mínimos no menor tempo possível
* Utilizar DDD como estrutura de projeto para back-end
* Realizar Two-way-data-binding para dar dinâmica na utilização da página

### SO
* Ubuntu 14.04 

### Tecnologias utilizadas
* Java 8
* SpringBoot
* Maven

* Angular I
* Npm
* Bower

* MySQL
* Liquibase

#### Instalar dependências npm
```shell
sudo apt-get update
sudo apt-get install nodejs
npm install
```

#### Instalar dependências bower para frontend
```shell
bower install
```

### Funcionalidades do sistema
* Exite usuário padrão ADMIN {username: admin, password: admin}
* Senhas todas criptografadas
* Usuário ADMIN só pode acessar a rota "/users"
* Usuário USER só pode acessar a rota "/cash-out"
* Usuários logados são salvos em cookies
* No back-end é criado um lista de usuários logados(autorizados) para controlar o acesso de no máximo 5 usuários
* Usuário ADMIN pode CRIAR, REMOVER, ATUALIZAR e PESQUISAR usuários
* Usuário USER pode Sacar uma quantia que seja divisível por 10 e que não supere o seu valor de Saldo no banco

### Considerações
Espero ter atingido um bom nível de programação a ponto de poder ser um bom candidato aos olhos da GSW.

Apesar do pouco tempo para desenvolver, acredito que consegui alcançar os objetivos que queria e particularmente
gostei do resultado.

Agradeço desde já a participação.