package co.edu.uniquindio.test;

import co.edu.uniquindio.model.cuentaBanco.CuentaBancaria;
import co.edu.uniquindio.model.cuentaBanco.TipoCuenta;

public class Test {
    public static void main(String[] args){
        try {
            CuentaBancaria cuentaA = new CuentaBancaria("Juan", "Perdomo", "1004", TipoCuenta.CORRIENTE);
            cuentaA.consignarValor(5000);
            cuentaA.consultarSaldo();
            //cuentaA.retirarValor(4000);
            //cuentaA.consultarSaldo();

            CuentaBancaria cuentaB = new CuentaBancaria("Jose", "Jose", "1002", TipoCuenta.AHORROS);
            cuentaB.setSaldo(4000);
            cuentaB.consultarSaldo();
            System.out.println(cuentaA.compararCuentas(cuentaB));
            cuentaA.enviarDinero(cuentaB, 6000);
            cuentaA.consultarSaldo();
            cuentaB.consultarSaldo();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
