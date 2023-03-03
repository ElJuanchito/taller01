package co.edu.uniquindio.model.empresa;

import java.util.ArrayList;
import java.util.List;

public class Directivo extends Empleado{
    private Categoria categoria;
    private List<Empleado> listaSubordinados;

    /**
     * Constructor base de Directivo.
     */
    public Directivo(){
    }

    /**
     *
     * @param nombre del directivo.
     * @param edad del directivo.
     * @param saldoBruto del directivo.
     * @param categoria del directivo.
     */
    public Directivo(String nombre, Integer edad, double saldoBruto, Categoria categoria) {
        super(nombre, edad, saldoBruto);
        this.categoria = categoria;
        this.listaSubordinados = new ArrayList<Empleado>();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Empleado> getListaSubordinados() {
        return listaSubordinados;
    }

    public void setListaSubordinados(List<Empleado> listaSubordinados) {
        this.listaSubordinados = listaSubordinados;
    }

    @Override
    public String toString() {
        return "Directivo{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", saldoBruto=" + getSalarioBruto() +
                ", categoria=" + getCategoria() +
                '}';
    }
}
