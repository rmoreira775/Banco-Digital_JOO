public abstract class Conta {
    protected Cliente cliente;
    protected double saldo;
    protected int numeroConta;

    public Conta(Cliente cliente, int numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if(valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino) {
        if(sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para conta " + destino.getNumeroConta() + " realizada.");
            return true;
        }
        return false;
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta " + numeroConta + " ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$" + saldo);
    }
}
