package co.edu.uniquindio.main;

import co.edu.uniquindio.model.cuentaBanco.Banco;
import co.edu.uniquindio.model.cuentaBanco.Cliente;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Comparator;

public class Main {

    //Tarea:
    // Crear nuevas exceptions personalizadas
    public static void main(String[] args) {

        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Luis", "Gomez", "7723");
        Cliente cliente2 = new Cliente("Jose", "Jose", "1234");

        Comparator<Cliente> comparatorEdad = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getEdad().compareTo(o2.getEdad());
            }
        };

        Comparator<Cliente> comparatorNombre = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        };

        Comparator<Cliente> comparatorId = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getDocumento().compareTo(o2.getDocumento());
            }
        };
    }

}
