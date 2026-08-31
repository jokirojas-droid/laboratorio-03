public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;
    private double comisionMensualFija;

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial,
                         double tasaInteres, double comisionMensualFija) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.comisionMensualFija = comisionMensualFija;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto positivo");
        if (getSaldo() >= monto) setSaldo(getSaldo() - monto);
        else throw new IllegalStateException("Saldo insuficiente");
    }

    @Override
    public void aplicarComisionMensual() {
        double saldo = Math.max(0, getSaldo() - comisionMensualFija);
        saldo += saldo * tasaInteres;
        setSaldo(saldo);
    }
}
