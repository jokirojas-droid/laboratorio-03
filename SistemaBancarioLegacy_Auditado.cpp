// SistemaBancarioLegacy_Auditado.cpp - Versión auditada y corregida
#include <iostream>
#include <string>

struct CuentaLegacy {
    std::string titular;  //  std::string (sin fugas)
    double saldo;
    int tipoCuenta;
    double limiteSobregiro;
};

CuentaLegacy* crearCuenta(const std::string& nombre, double saldoInicial, int tipo) {
    CuentaLegacy* c = new CuentaLegacy();
    c->titular = nombre;
    c->saldo = saldoInicial;
    c->tipoCuenta = tipo;
    c->limiteSobregiro = (tipo == 2) ? 500.0 : 0.0;
    return c;
}

void destruirCuenta(CuentaLegacy* c) {
    delete c;  // std::string se destruye solo
}

void procesarRetiro(CuentaLegacy* c, double monto) {
    if (!c) return;
    if (c->tipoCuenta == 1) { // Ahorros
        if (c->saldo >= monto) c->saldo -= monto;
        else std::cerr << "Saldo insuficiente.\n";
    } else if (c->tipoCuenta == 2) { // Corriente
        if ((c->saldo + c->limiteSobregiro) >= monto) {
            c->saldo -= monto;
            if (c->saldo < 0) std::cout << "Sobregiro activado.\n";
        } else std::cerr << "Límite excedido.\n";
    }
}

int main() {
    CuentaLegacy* c1 = crearCuenta("Juan", 1000, 1);
    procesarRetiro(c1, 200);
    std::cout << "Saldo: " << c1->saldo << "\n";
    destruirCuenta(c1);
    return 0;
}
