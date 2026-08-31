public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
        else throw new IllegalArgumentException("Monto positivo requerido");
    }

    public abstract void retirar(double monto);
    public abstract void aplicarComisionMensual();

    @Override
    public String toString() {
        return "Cuenta " + numeroCuenta + " | Titular: " + titular + " | Saldo: " + saldo;
    }
}
