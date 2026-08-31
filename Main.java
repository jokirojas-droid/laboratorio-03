public class Main {
    public static void main(String[] args) {
        try (RegistroAuditoriaBancaria log = new RegistroAuditoriaBancaria("auditoria.log")) {
            CuentaAhorros ahorros = new CuentaAhorros("AH-001", "Carlos", 5000, 0.02, 10);
            CuentaCorriente corriente = new CuentaCorriente("CC-001", "Ana", 1000, 500, 0.01);

            log.registrar("Creada " + ahorros);
            log.registrar("Creada " + corriente);

            ahorros.retirar(200);
            log.registrar("Retiro 200 en ahorros. Saldo: " + ahorros.getSaldo());

            corriente.retirar(1200); // usa sobregiro
            log.registrar("Retiro 1200 en corriente. Saldo: " + corriente.getSaldo());

            ahorros.aplicarComisionMensual();
            corriente.aplicarComisionMensual();
            log.registrar("Comisiones aplicadas.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
