/*Realizado por:
    - Pérez Galindo Claudia
    -Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general

    Representa a una persona que puede solicitar préstamos. Hereda de la clase Persona.
*/

public class Usuario extends Persona {

    // Declaracion de atributos ---------------------------------------------------------------

    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;

    // Declaracion de constructores -------------------------------------------------

    public Usuario() {
        super();
        this.librosPrestados = 0;
        this.telefonoCelular = "";
        this.activo = true;
    }

    public Usuario(int id, String nombre, String correo, boolean activo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.librosPrestados = 0;
        this.telefonoCelular = "66-66-66-66-66";
        this.activo = activo;
    }

    // Declaracion de métodos -----------------------------------------------------------------

    public void solicitarPrestamo() {
        if (this.activo) {
            this.librosPrestados++;
        }
    }

    public void devolverLibro() {
        if (this.librosPrestados > 0) {
            this.librosPrestados--;
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Correo: " + this.correo);
        System.out.println("Estado: " + (this.activo ? "Activo" : "Inactivo"));
        System.out.println("Teléfono Celular: " + this.telefonoCelular);
        System.out.println("Libros Prestados: " + this.librosPrestados);
    }

    // Declaracion de métodos especiales ------------------------------------------------------

    // Setters
    public void setLibrosPrestados(int librosPrestados) {

        this.librosPrestados = librosPrestados;
    }

    public void setTelefonoCelular(String telefonoCelular) {

        this.telefonoCelular = telefonoCelular;
    }

    public void setActivo(boolean activo) {

        this.activo = activo;
    }

    // Getters
    public int getLibrosPrestados() {

        return librosPrestados;
    }

    public String getTelefonoCelular() {

        return telefonoCelular;
    }

    public boolean isActivo() {

        return activo;
    }
}