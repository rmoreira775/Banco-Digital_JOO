public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando 10 clientes
        
        Cliente[] clientes = new Cliente[] {
                new Cliente("João Silva", "111.222.333-44"),
                new Cliente("Maria Oliveira", "555.666.777-88"),
                new Cliente("Carlos Souza", "999.888.777-66"),
                new Cliente("Ana Pereira", "444.333.222-11"),
                new Cliente("Marcos Lima", "222.333.444-55"),
                new Cliente("Fernanda Costa", "777.666.555-44"),
                new Cliente("Paula Ribeiro", "123.456.789-00"),
                new Cliente("Rafael Gomes", "987.654.321-11"),
                new Cliente("Beatriz Santos", "456.789.123-22"),
                new Cliente("Lucas Alves", "321.654.987-33")
        };

        // Adicionando clientes no banco

        for (Cliente cliente : clientes) {
            banco.adicionarCliente(cliente);
        }


        // Criando contas para cada cliente (conta corrente para índices pares, poupança para ímpares)

        for (int i = 0; i < clientes.length; i++) {
            Cliente cliente = clientes[i];
            Conta conta;
            int numeroConta = 1000 + i;

            if (i % 2 == 0) {
                conta = new ContaCorrente(cliente, numeroConta, 500);
            } else {
                conta = new ContaPoupanca(cliente, numeroConta);
            }

            banco.adicionarConta(conta);

            // Depositando um valor inicial variável para cada conta

            double valorInicial = 1000 + i * 100;
            conta.depositar(valorInicial);
            System.out.println("Conta criada para " + cliente.getNome() + " - Número: " + numeroConta + " - Saldo inicial: R$" + valorInicial);
        }

        System.out.println("\n=== Executando operações bancárias ===");

        // Exemplo: Cliente 0 (João Silva) saca 200

        Conta contaJoao = banco.buscarConta(1000);
        System.out.println("\nSaque de R$200 da conta " + contaJoao.getNumeroConta() + " de " + contaJoao.getCliente().getNome());
        contaJoao.sacar(200);

        // Cliente 1 (Maria Oliveira) transfere R$150 para Cliente 2 (Carlos Souza)

        Conta contaMaria = banco.buscarConta(1001);
        Conta contaCarlos = banco.buscarConta(1002);
        System.out.println("\nTransferência de R$150 da conta " + contaMaria.getNumeroConta() + " (" + contaMaria.getCliente().getNome() + ") para conta " + contaCarlos.getNumeroConta() + " (" + contaCarlos.getCliente().getNome() + ")");
        contaMaria.transferir(150, contaCarlos);

        // Aplicando rendimento nas contas poupança

        System.out.println("\nAplicando rendimento nas contas poupança...");
        for (Conta conta : banco.getContas()) {
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).aplicarRendimento();
            }
        }

        // Imprimindo extratos finais

        System.out.println("\n=== Extratos finais das contas ===");
        for (Conta conta : banco.getContas()) {
            conta.imprimirExtrato();
            System.out.println("---------------------------");
        }
    }
}
