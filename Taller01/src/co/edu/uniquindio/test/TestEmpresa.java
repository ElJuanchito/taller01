package co.edu.uniquindio.test;

import co.edu.uniquindio.model.empresa.*;

public class TestEmpresa {

    public static void main(String[] args) throws Exception {
        Empresa empresa = new Empresa("Uq empresa");

        Persona persona = new Empleado("Juan", 23, 23445);

        Cliente cliente = new Cliente("Luz", 23, "3224343");

        Directivo directivo = new Directivo("Carlos", 19, 5000000, Categoria.GERENTE);

        directivo.getListaSubordinados().add((Empleado)persona);

        empresa.getListaPersona().add(persona);
        empresa.getListaPersona().add(cliente);
        empresa.getListaPersona().add(directivo);

        Persona persona2 = new Empleado("Ana", 23, 23445);

        empresa.imprimirSalarioEmpleados();

        //hacer un metodo que imprima el salario bruto de los empleados, debe manipular la lista personas de la empresa
    }
}
