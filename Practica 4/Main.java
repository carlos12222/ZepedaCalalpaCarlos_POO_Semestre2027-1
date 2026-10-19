/*Realizado por:
    - Pérez Galindo Claudia
    -Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general

    Probador, ya no se q no jala basta
*/

public class Main {

    // Declaracion de métodos -----------------------------------------------------------------

    public static void main(String[] args) {

        System.out.println("---------- ");

        System.out.println("\n--- Registro de Libros ---");
        Libro libro1 = new Libro("111", "Java Básico", "Autor A", 2021, true);
        Libro libro2 = new Libro("222", "Clean Code", "Robert C. Martin", 2008, true);
        Libro libro3 = new Libro("333", "Patrones de Diseño", "GoF", 1994, true);

        System.out.println("Libros registrados:");
        System.out.println(libro1.getTitulo());
        System.out.println(libro2.getTitulo());
        System.out.println(libro3.getTitulo());

        System.out.println("\n--- Registro de Usuarios ---");
        Usuario usuario1 = new Usuario(1, "Juan Pérez", "juan@unam.mx", true);
        Usuario usuario2 = new Usuario(2, "María Gómez", "maria@unam.mx", true);

        System.out.println("Usuarios registrados:");
        System.out.println(usuario1.getNombre());
        System.out.println(usuario2.getNombre());

        System.out.println("\n--- Solicitud de Préstamo ---");
        Prestamo prestamoJuan = new Prestamo(usuario1, libro2);
        prestamoJuan.iniciarPrestamo();

        System.out.println("¿Libro disponible?: " + libro2.estaDisponible());
        System.out.println("¿Préstamo activo?: " + prestamoJuan.estaActivo());

        System.out.println("\n--- Devolución de Libro ---");
        prestamoJuan.finalizarPrestamo();

        System.out.println("¿Libro disponible?: " + libro2.estaDisponible());
        System.out.println("¿Préstamo activo?: " + prestamoJuan.estaActivo());

    }
}