public class CuentaCorriente extends CuentaBancaria {
    private double cupoSobregiro;
    private double comisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double cupoSobregiro, double comisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
        this.comisionSobregiro = comisionSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto positivo");
        double nuevoSaldo = getSaldo() - monto;
        if (nuevoSaldo >= -cupoSobregiro) setSaldo(nuevoSaldo);
        else throw new IllegalStateException("Límite de sobregiro excedido");
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < 0) {
            double interes = getSaldo() * comisionSobregiro; // negativo
            setSaldo(getSaldo() + interes);
        }
    }
}
