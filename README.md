💻Banco Digital em Java - Projeto Orientado a Objetos
Descrição

Projeto prático para reforçar os conceitos de Programação Orientada a Objetos (POO) em Java. Este sistema simula um banco digital com as principais funcionalidades básicas de uma conta bancária, contemplando os pilares da orientação a objetos:

👍 Abstração: Classes representam entidades do domínio bancário (Conta, Cliente, Banco).

👍 Encapsulamento: Atributos privados com acesso controlado via métodos públicos.

👍 Herança: Especialização de contas através das classes ContaCorrente e ContaPoupanca.

👍 Polimorfismo: Uso de referências genéricas para manipular diferentes tipos de contas.



🛠 Funcionalidades

Criar clientes e associar contas (corrente e poupança).

Realizar depósitos, saques e transferências entre contas.

Aplicar rendimento mensal na conta poupança.

Imprimir extratos detalhados das contas.

Estrutura do Projeto

Cliente.java: Representa o cliente do banco.

Conta.java: Classe base abstrata para contas bancárias.

ContaCorrente.java: Conta corrente com limite de cheque especial.

ContaPoupanca.java: Conta poupança com rendimento mensal.

Banco.java: Gerencia clientes e contas.

Main.java: Classe principal com exemplos de uso e testes das funcionalidades.
