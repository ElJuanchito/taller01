package co.edu.uniquindio.model.cuentaBanco;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco{
    private String nombre;
    private List<CuentaBancaria> listaCuentas;
    private List<Cliente> listaClientes;


    public Banco() {
    }

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaCuentas = new ArrayList<CuentaBancaria>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<CuentaBancaria> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(nombre, banco.nombre) && Objects.equals(listaCuentas, banco.listaCuentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, listaCuentas);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", listaCuentas=" + listaCuentas +
                '}';
    }

    /**
     * Busca la cuenta en la lista del banco y la retorna. En caso de no encontrarla, lanza
     * una exception
     * @param noCuenta no de la cuenta a buscar
     * @return retorna la cuenta econtrada
     * @throws Exception puede no econtrar la cuenta
     */
    public CuentaBancaria buscarCuenta(String noCuenta) throws Exception {
        CuentaBancaria cuenta;
        for (CuentaBancaria cuenta1 : getListaCuentas()) {
            if (cuenta1.getNumeroCuenta().equals(noCuenta)) {
                cuenta = cuenta1;
                return cuenta;
            }
        }
        throw new Exception("no se econtro la cuenta");
    }

    /**
     * valida la cuenta en la lista del banco
     * @param noCuenta
     * @return retorna Verdadero si la cuenta ya existe o falso si no
     */
    private boolean validarCuenta(String noCuenta){
        for (CuentaBancaria cuenta: listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(noCuenta)) return true;
        }return false;
    }

    /**
     * Agrega una nueva cuenta la lista del banco despues de verificarla
     * @param noCuenta numero de la cuenta a crear
     * @param tipoCuenta : tipo de la cuenta crear
     */
    public void addCuenta(String noCuenta, TipoCuenta tipoCuenta){
        if(!validarCuenta(noCuenta))  listaCuentas.add(new CuentaBancaria(noCuenta, tipoCuenta));
    }

    /**
     * valida al cliente en la lista del banco
     * @param documento del cliente a validar
     * @return retorna Verdadero si la cuenta ya existe o falso si no

     */
    private boolean validarCliente(String documento) {
        for (Cliente cliente1: listaClientes){
            if(cliente1.getDocumento().equals(documento)) return true;
        }return false;
    }

    /**
     * Agrega un nuevo cliente la lista despues de verificarlo
     * @param nombre del cliente a crear
     * @param apellido del cliente a crear
     * @param documento del cliente a crear
     */
    public void addCliente(String nombre, String apellido, String documento) {
       if(!validarCliente(documento)) listaClientes.add(new Cliente(nombre, apellido, documento));
    }

    /**
     * Retira dinero a una cuenta por medio del numero de cuenta
     * @param valor a retirar
     * @param noCuenta numero de la cuenta
     * @throws Exception lanza una exception si la cuenta no se encuentra
     */
    public void retirarDinero(double valor, String noCuenta) throws Exception {
        if(validarCuenta(noCuenta)) buscarCuenta(noCuenta).retirarValor(valor);
    }

    /**
     * Consigna dinero a una cuenta por medio del numero de cuenta
     * @param valor a consignar
     * @param noCuenta numero de la cuenta
     * @throws Exception lanza una exception si la cuenta no se encuentra
     */
    public void consignarDinero(double valor, String noCuenta) throws Exception {
        if(validarCuenta(noCuenta)) buscarCuenta(noCuenta).consignarValor(valor);
    }

    /**
     * tranfiere dinero entre cuentas
     * @param valor a transferir
     * @param noCuentaA numero de la cuenta que envia el dinero
     * @param noCuentaB numero de la cuenta que recibe el dinero
     * @throws Exception lanza exception si se excede el saldo de una cuenta
     */
    public void tranferirDinero(double valor, String noCuentaA, String noCuentaB) throws Exception {
        if(validarCuenta(noCuentaA)) {
            if (validarCuenta(noCuentaB)) buscarCuenta(noCuentaA).enviarDinero(buscarCuenta(noCuentaB), valor);
        }
    }

    /**
     * Consulta el saldo y lo devuelve con una cadena de caracteres
     * @param noCuenta numero de la cuenta a consultar
     * @return retorna el saldo de la cuenta
     * @throws Exception lanza una exception si no encuentra la cuenta
     */
    public String consultarSaldo(String noCuenta) throws Exception {
        return buscarCuenta(noCuenta).toString();
    }
}
