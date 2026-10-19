/*Realizado por:
    - Pérez Galindo Claudia
    -Zepeda Calalpa Carlos

-----------------------------------
Funcionamiento general



*/
public class Libro {
    // Declaracion de atributos ---------------------------------------------------------------

    private String isbn;
    private String titulo;
    private String autor;
    private int publicacion;
    private boolean disponible;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, int publicacion, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacionublicacion(int anioPublicacion) {
        this.publicacion = anioPublicacion;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    public void mostrarInformacion() {
        System.out.println("--- Datos del Libro ---");
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Año de publicación: " + this.publicacion);

        if (this.disponible) {
            System.out.println("Estado: Disponible ");
        } else {
            System.out.println("Estado: Aqui no ta");
        }
    }
}