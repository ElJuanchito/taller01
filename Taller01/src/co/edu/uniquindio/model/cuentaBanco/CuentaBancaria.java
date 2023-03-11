package co.edu.uniquindio.model.cuentaBanco;

import javax.swing.*;

public class CuentaBancaria {
    private String numeroCuenta;
    private Double saldo;
    private TipoCuenta tipoCuenta;

    public CuentaBancaria(){
    }

    /**
     * Constructor de Cuenta Bancaria.
     * @param numeroCuenta numero de la cuenta.
     * @param tipoCuenta tipo de cuenta: ahorros o corriente.
     */
    public CuentaBancaria(String numeroCuenta, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0d;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }

    /**
     * Consultar el saldo actual de la cuenta.
     * @return saldo actual de la cuenta
     */
    public void consultarSaldo(){
        JOptionPane.showMessageDialog(null, " su saldo actual: " + saldo);
    }

    /**
     * Retirar saldo de la cuenta.
     * @param valor a retirar
     * @throws Exception el valor a retirar no puede exceder el saldo actual.
     */
    public void retirarValor(double valor) throws Exception {
        if(valor > saldo){
            throw new Exception("El valor a retirar supera el saldo en cuenta");
        }
        saldo-= valor;
    }

    /**
     * Consignar saldo a la cuenta.
     * @param valor a consignar.
     * @throws Exception el valor minimo a consignar debe ser mayor a 0.
     */
    public void consignarValor(double valor) throws Exception {
        if(valor == 0){
            throw new Exception("No puede cosignar el valor de 0.0");
        }
        saldo+= valor;
    }

    /**
     * Compara dos cuentas y retorna un booleano segun el saldo
     * @param cuentaB cuenta bancaria a comparar.
     * @return retorna True si el saldo de la cuenta es mayor o igual a la cuentaB.
     */
    public boolean compararCuentas(CuentaBancaria cuentaB) {
        if (saldo >= cuentaB.saldo) return true;
        return false;
    }

    /**
     * envia dinero entre cuentas
     * @param cuentaB : cuenta a la que se le envia el dinero.
     * @param valor a enviar.
     * @throws Exception exception al retirar dinero de la cuenta actual.
     */
    public void enviarDinero(CuentaBancaria cuentaB, double valor) throws Exception {
        retirarValor(valor);
        cuentaB.consignarValor(valor);

    }





}
