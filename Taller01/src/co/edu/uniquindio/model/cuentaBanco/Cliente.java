package co.edu.uniquindio.model.cuentaBanco;


import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private String apellido;
    private String documento;
    private Integer edad;
    private List<CuentaBancaria> listaCuentas;

    /**
     * Constructor vacio de Cliente
     */
    public Cliente() {
    }

    /**
     *
     * @param nombre del cliente
     * @param apellido del cliente
     * @param documento del cliente
     */
    public Cliente(String nombre, String apellido, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.listaCuentas = new ArrayList<CuentaBancaria>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<CuentaBancaria> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Agrega una nueva cuenta la lista del cliente despues de verificarla
     * @param noCuenta numero de la cuenta a crear
     * @param tipoCuenta : tipo de la cuenta crear
     * @throws Exception
     */
    public void addCuenta(String noCuenta, TipoCuenta tipoCuenta) throws Exception {
        if(!validarCuenta(noCuenta))  listaCuentas.add(new CuentaBancaria(noCuenta, tipoCuenta));
    }

    /**
     * valida la cuenta en la lista de clientes
     * @param noCuenta
     * @return retorna Verdadero si la cuenta ya existe o falso si no
     * @throws Exception
     */
    private boolean validarCuenta(String noCuenta) throws Exception {
        for (CuentaBancaria cuenta: listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(noCuenta)) return true;
        }return false;
    }

    @Override
    public int compareTo(Cliente a) {
        return this.getNombre().compareTo(a.getNombre());
    }
}
