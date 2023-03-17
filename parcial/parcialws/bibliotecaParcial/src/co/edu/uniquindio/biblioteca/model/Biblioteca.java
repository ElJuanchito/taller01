package co.edu.uniquindio.biblioteca.model;

import javax.swing.JOptionPane;

import org.junit.experimental.theories.FromDataPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    //ATRIBUTOS
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Estudiante> listaEstudiantes;
    private List<Prestamo> listaPrestamos;
    private List<Empleado> listaEmpleados;
    private List<Libro> listaLibros;

    public Biblioteca() {

    }

    /**
     * Este es el metodo constructor de la clase biblioteca
     * @param nombre
     * @param direccion
     * @param telefono
     */
    public Biblioteca(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaEstudiantes = new ArrayList<Estudiante>();
        this.listaPrestamos = new ArrayList<Prestamo>();
        this.listaEmpleados = new ArrayList<Empleado>();
        this.listaLibros = new ArrayList<Libro>();
    }

    /**
     * obtiene el nombre de la biblioteca
     * @return nombre biblioteca
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre a la biblioteca
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la direccion de la biblioteca
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna una direccion a la biblioteca
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el telefono de la biblioteca
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna un telefono a la biblioteca
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * retorna una lista de objetos "Estudiante". Este método no modifica la lista, simplemente la retorna
     * @return
     */
    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    /**
     * recibe una lista de objetos "Estudiante" como argumento y la asigna al atributo "listaPrestamos" de la clase.
     * @param listaEstudiantes
     */
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    /**
     * retorna una lista de objetos "Prestamo". Este método no modifica la lista, simplemente la retorna
     * @return
     */
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    /**
     * recibe una lista de objetos "Prestamo" como argumento y la asigna al atributo "listaPrestamos" de la clase.
     * @param listaPrestamos
     */
    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    /**
     * retorna una lista de objetos "Empleado". Este método no modifica la lista, simplemente la retorna
     * @return
     */
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    /**
     * recibe una lista de objetos "Empleado" como argumento y la asigna al atributo "listaPrestamos" de la clase.
     * @param listaEmpleados
     */
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    /**
     * retorna una lista de objetos "Libro". Este método no modifica la lista, simplemente la retorna
     * @return
     */
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    /**
     * recibe una lista de objetos "Libro" como argumento y la asigna al atributo "listaPrestamos" de la clase.
     * @param listaLibros
     */
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
    }

    /**
     * Este metodo permite crear un estudiante
     * @param nombres
     * @param apellidos
     * @param edad
     * @param programa
     * @param estado
     * @param identificacion
     * @throws Exception
     */
    public String crearEstudiante(String nombres, String apellidos, Integer edad, String programa, String estado,
                                  String identificacion) throws Exception{

        String mensaje = "El estudiante ha sido registrado";
        boolean estudianteEncontrado = verificarEstudiante(identificacion);
        if( estudianteEncontrado == true){
            throw new Exception("El estudiante ya existe");
        }else{
            Estudiante nuevoEstudiante = new Estudiante(nombres, apellidos, edad, programa, estado, identificacion);
            listaEstudiantes.add(nuevoEstudiante);
        }
        return mensaje;
    }

    /**
     * Obtener un estudiante
     * @param identificacion
     * @return
     */
    public Estudiante obtenerEstudiante (String identificacion){

        Estudiante estudianteEncontrado = null;

        for (Estudiante estudiante : listaEstudiantes) {
            if(estudiante.getIdentificacion().equals(identificacion)){
                estudianteEncontrado = estudiante;
            }
        }
        return estudianteEncontrado;
    }

    /**
     * elimina un estudiante de la lista
     * @param identificacion
     * @throws Exception
     */
    public void eliminarEstudiante(String identificacion) throws Exception
    {
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null){
            throw new Exception("El estudiante no esta registrado");
        }
        listaEstudiantes.remove(estudianteEncontrado);
    }

    /**
     * Actualiza los datos de un estudiante existente
     * @param nombres
     * @param apellidos
     * @param identificacion
     * @param edad
     * @return
     * @throws Exception si no existe, lanza un error
     */
    public String actualizarEstudiante(String nombres , String apellidos , String identificacion, Integer edad) throws Exception{
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null){
            throw new Exception("El estudiante no esta registrado");
        }
        estudianteEncontrado.setNombres(nombres);
        estudianteEncontrado.setApellidos(apellidos);

        estudianteEncontrado.setEdadEstudiante(edad);

        return " El estudiante ha sido actualizado " ;
    }

    /** Ordena los libros de la lista en base al ISBN
     *
     */
    public void ordenarLibrosPorISBN() {
        Collections.sort(listaEstudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante estudiante1, Estudiante estudiante2) {
                return estudiante1.getIdentificacion().compareTo(estudiante2.getIdentificacion());
            }
        });
    }



    /** verifica si existe un estudiante por medio de la identificacion
     *
     * @param identificacion
     * @return
     */
    private boolean verificarEstudiante(String identificacion) {
        boolean verificado = false;
        for (Estudiante estudianteaux : listaEstudiantes) {
            if(estudianteaux.getIdentificacion().equals(identificacion)){
                verificado = true;
                return verificado;
            }
        }
        return verificado;
    }

    /**
     * Obtiene los estudiantes con una edad mayor a la indicada
     * @param edad
     * @return
     */
    public ArrayList<Estudiante> obtenerEstudiantesEdadMayor (int edad){
        ArrayList<Estudiante> listaEstudiantesEncontrados = new ArrayList<Estudiante>();

        for (Estudiante estudiante : listaEstudiantes) {
            if(estudiante.verificarEdad(edad)){
                listaEstudiantesEncontrados.add(estudiante);
            }
        }
        return listaEstudiantesEncontrados;
    }

    /** Entrega los prestamos en base al total y el autor
     *
     * @param autor
     * @param valor
     * @return
     */
    public ArrayList<Prestamo> obtenerPrestamosTotalAutor (String autor, double valor){
        ArrayList<Prestamo> prestamosEncontrados = new ArrayList<Prestamo>();

        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.verificarTotalAutor(autor,valor) == true){
                prestamosEncontrados.add(prestamo);
            }
        }
        return prestamosEncontrados;
    }
    //-----------------------------------------------------------------------------------------------------
    /** Entrega el empleado que presto el libro indicado por el ISBN
     *
     * @return
     * @throws PrestamoException
     */
    public String obtenerEmpleadoPrestamoLibroIsbn(String isbn) throws PrestamoException{
        String empleadoEncontrado = "";

        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.cumpleIsbn(isbn)){
                empleadoEncontrado = prestamo.getEmpleadoPrestamo().toString();
                return empleadoEncontrado;
            }
        }

        throw new PrestamoException("NO existe un prestamo para el isbn");
    }

    //punto 2

    /**
     * Restorna el prestamo econtrado segundo los datos indicados en los parametros
     * @param titulo
     * @param limiteInferior
     * @param limiteSuperior
     * @param aniosExperiencia
     * @return
     */
    public Prestamo devolverPrestamoLibro(String titulo,int limiteInferior,int limiteSuperior,int aniosExperiencia){

        Prestamo prestamoEncontrado = null;
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior,aniosExperiencia)){
                prestamoEncontrado = prestamo;
                return prestamoEncontrado;
            }
        }
        return prestamoEncontrado;
    }

    //Consultar cual es el tipo de libro que ha sido prestado
    //m�s veces en la biblioteca, seg�n sus unidades prestadas. (1.0).

    /**
     * Retorna el tipo de libro mas prestado
     * @return
     */
    public Tipo obtenerTipoMasPrestado(){

        Tipo tipoMasPrestado;

        int totalPrestadoBiografia = obtenerTotalPrestado(Tipo.BIOGRAFIA);
        int totalPrestadoCientifico = obtenerTotalPrestado(Tipo.Cientifico);
        int totalPrestadoMonografia = obtenerTotalPrestado(Tipo.MONOGRAFIA);

        if (totalPrestadoBiografia > totalPrestadoCientifico && totalPrestadoBiografia > totalPrestadoMonografia) {
            tipoMasPrestado = Tipo.BIOGRAFIA;
        } else {
            if (totalPrestadoCientifico > totalPrestadoMonografia) {
                tipoMasPrestado = Tipo.Cientifico;
            } else {
                tipoMasPrestado = Tipo.MONOGRAFIA;
            }
        }

        return tipoMasPrestado;
    }

    /**
     * Obtiene el total de libros prestados segun el tipo indicado
     * @param tipo
     * @return
     */
    private int obtenerTotalPrestado(Tipo tipo) {

        int cantidad = 0;
        for (Prestamo prestamo : listaPrestamos) {
            cantidad += prestamo.obtenerCantidadTipo(tipo);
        }

        return cantidad;
    }
}
