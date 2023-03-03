package co.edu.uniquindio.model.empresa;

import java.util.Objects;

public class Cliente extends Persona{
    private String telefono;

    /**
     * Constructor base de Cliente.
     */
    public Cliente(){
    }

    /**
     *
     * @param nombre del cliente.
     * @param edad del cliente.
     * @param telefono del cliente.
     */

    public Cliente(String nombre, Integer edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono);
    }


}
