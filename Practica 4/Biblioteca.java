import java.util.ArrayList;

/*Realizado por:
    - Pérez Galindo Claudia
    -Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Ya medio unido esto
*/

public class Biblioteca {

    // Declaracion de atributos ---------------------------------------------------------------

    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bibliotecario> empleados;
    private ArrayList<Prestamo> prestamos;

    // Declaracion de constructores -------------------------------------------------

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // Declaracion de métodos -----------------------------------------------------------------

    // Gestión de Libros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Se agregó con exito");
    }

    public void eliminarLibro(String isbn) {
        Libro libroEncontrado = buscarLibro(isbn); //---------------------> Necesito hacer buscar pero aja
        if (libroEncontrado != null) {
            libros.remove(libroEncontrado);
            System.out.println("Aqui ya no ta");
        }
    }

    // Aqui iria lo se buscar libro si le entendiera

    // Aqui iria lo de buscar autor si le entendiera

    public void mostrarCatalogo() {
        System.out.println("--- Catálogo ---");
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
    }

    //  Gestión de Usuarios -----------------------------------------------------------------------------------------------
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado cocn exito");
    }

    // Me falta buscar al usuarii ahhhhhh

    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            u.mostrarInformacion();
        }
    }

    // Gestión de Préstamos -----------------------------------------------------------------------------------------------
    public void realizarPrestamo(Usuario usuario, Libro libro) {
        Prestamo nuevoPrestamo = new Prestamo(usuario, libro);
        nuevoPrestamo.iniciarPrestamo();
        prestamos.add(nuevoPrestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamo.finalizarPrestamo();
    }

    // Falta enseñar que prestamos estan activos
}