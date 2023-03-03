package co.edu.uniquindio.model.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private String nombre;
    private List<Persona> listaPersona;

    /**
     * Constructor base de Empresa.
     */
    public Empresa() {
    }

    /**
     *
     * @param nombre de la empresa.
     */
    public Empresa(String nombre) {
        this();
        this.listaPersona = new ArrayList<Persona>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nombre, empresa.nombre) && Objects.equals(listaPersona, empresa.listaPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, listaPersona);
    }

    public boolean imprimirSalarioEmpleado(Empleado empleado) {
        for(Persona persona: getListaPersona()){
            if (persona.equals(empleado)){
                return true;
            }
        }
        return false;
    }
}
