public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, int numeroConta, double limiteChequeEspecial) {
        super(cliente, numeroConta);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor > 0 && saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com cheque especial.");
            return true;
        } else {
            System.out.println("Saldo e limite insuficientes para saque.");
            return false;
        }
    }
}
