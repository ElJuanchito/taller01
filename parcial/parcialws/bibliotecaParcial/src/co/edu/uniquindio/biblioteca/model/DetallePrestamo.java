package co.edu.uniquindio.biblioteca.model;

public class DetallePrestamo {
    private String codigo;
    private double subTotal;
    private int cantidad;
    private Libro libro;

    public DetallePrestamo(){

    }

    /**
     * Este es el constructor de la clase DetallePrestamo
     * @param codigo
     * @param subTotal
     * @param cantidad
     * @param libro
     */
    public DetallePrestamo(String codigo, double subTotal, int cantidad, Libro libro) {
        super();
        this.codigo = codigo;
        this.subTotal = subTotal;
        this.cantidad = cantidad;
        this.libro = libro;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    @Override
    public String toString() {
        return "DetallePrestamo [codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + ", libro="
                + libro + "]";
    }

    /**
     * Retorna verdadero o falso segun si la cantidad supera las 20 unidades
     * @return
     */
    public boolean verificarCantidad() {

        if(cantidad > 20){
            return true;
        }
        return false;
    }

    /**
     * verifica si el isbn ingresado es el mismo del libro prestado
     * @param isbn
     * @return
     */
    public boolean cumpleIsbn(String isbn) {
        return libro.cumpleIsbn(isbn);
    }

    /**
     * verifica si los datos ingresados cumplen con los parametros
     * @param titulo
     * @param limiteInferior
     * @param limiteSuperior
     * @return
     */
    public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior) {

        boolean cumpleNombre = false;
        boolean cumpleCantidad = false;

        cumpleCantidad = verificarRango(limiteInferior,limiteSuperior);
        cumpleNombre = verificarNombre(titulo);

        if(cumpleCantidad && cumpleNombre){
            return true;
        }
        return false;
    }

    /**
     * Verifica si el titulo ingresado es igual al del libro prestado
     * @param titulo
     * @return
     */
    private boolean verificarNombre(String titulo) {
        return getLibro().getTitulo().equals(titulo);
    }

    /**
     * Verifica que los limites ingresado no excedan la cantidad de prestamos
     * @param limiteInferior
     * @param limiteSuperior
     * @return
     */
    private boolean verificarRango(int limiteInferior, int limiteSuperior) {
        if(cantidad >= limiteInferior && cantidad < limiteSuperior) return true;
        return false;
    }

    /**
     * verifica si el tipo de libro es el mismo al del prestamo
     * @param tipo
     * @return
     */
    public boolean cumpleTipo(Tipo tipo) {

        return getLibro().getTipo() == tipo;
    }
}
