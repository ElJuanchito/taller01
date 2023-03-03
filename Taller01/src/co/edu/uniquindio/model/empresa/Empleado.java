package co.edu.uniquindio.model.empresa;

import java.util.Objects;

public class Empleado extends Persona{

    private Double salarioBruto;

    /**
     * Constructor base de Empleado.
     */
    public Empleado(){
    }

    /**
     *
     * @param nombre del empleado.
     * @param edad del empleado.
     * @param saldoBruto del empleado.
     */
    public Empleado(String nombre, Integer edad, double saldoBruto){
        super(nombre, edad);
        this.salarioBruto = saldoBruto;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (this.getNombre().equals(((Empleado) o).getNombre()))
            if (this.getSalarioBruto().equals(((Empleado) o).getSalarioBruto()))
                if (this.getEdad().equals(((Empleado) o).getEdad())){
                    return true;
                }
        Empleado empleado = (Empleado) o;
        return Objects.equals(salarioBruto, empleado.salarioBruto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salarioBruto);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                "saldoBruto=" + salarioBruto +
                '}';
    }

    public void imprimirSalario(){
        System.out.println(salarioBruto);
    }

}
