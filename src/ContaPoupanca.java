public class ContaPoupanca extends Conta {

    private double rendimentoMensal; // porcentagem de rendimento, ex: 0.005 = 0,5%

    public ContaPoupanca(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
        this.rendimentoMensal = 0.005; // exemplo: 0,5% ao mês
    }

    public void aplicarRendimento() {
        double valorRendimento = saldo * rendimentoMensal;
        saldo += valorRendimento;
        System.out.println("Rendimento aplicado: R$" + String.format("%.2f", valorRendimento));
    }
}
