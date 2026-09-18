import java.util.Scanner;
/*
En este programa vamos trabajar con StringBuffer, StringBuilder y Wrappers.
Vamos a pedir el nombre y la edad del usuario y con StringBuffer vamos a agregar texto al nombre y con StringBuilder
a invertir el nombre.
También se usará Integer, que es el Wrapper de int.
*/
public class Programa1 {
    //Este método recibe el nombre y lo guarda en un StringBuffer.
    //Después se utiliza append para agregar "Estudiante" al final.

    // Método para trabajar con StringBuffer
    public static String modificarConStringBuffer(String nombre) {
        StringBuffer texto = new StringBuffer(nombre);

        // Agrega texto al final, también con append se puede agregar más texto
        texto.append(" - Estudiante");
        //Se retorna un resultado de tipo string
        return texto.toString();
    }
    // Método para trabajar con StringBuilder
    public static String modificarConStringBuilder(String nombre) {
        StringBuilder texto = new StringBuilder(nombre);
        // Convierte el nombre a mayúsculas
        texto.reverse();
        return texto.toString();
    }

    //Este método solicita la edad del usuario y comprueba
    //que se introduzca un número entero dentro de un rango válido.
    // Método para validar la edad
    public static Integer obtenerEdad(Scanner entrada) {
        int edad;
        while (true) {
            System.out.print("Ingresa tu edad: ");
            //hasNextInt() permite comprobar si la entrada
            //corresponde a un número entero.
            if (entrada.hasNextInt()) {
                edad = entrada.nextInt();
                // Se establece un rango razonable para la edad
                if (edad > 0 && edad <= 120) {
                    //Se utiliza Integer en lugar de int.
                    //Integer es el Wrapper de int.
                    return Integer.valueOf(edad);
                }
                System.out.println("La edad debe estar entre 1 y 120.");
            } else {
                // Se informa al usuario cuando introduce un dato incorrecto
                System.out.println("Debes ingresar un número entero.");
                // Se elimina la entrada incorrecta
                entrada.next();
            }
        }
    }
    //Este es el método principal del programa.
    //Desde aquí se solicitan los datos y se llaman los demás métodos.
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("===== PROGRAMA 1 =====");
        System.out.println("StringBuffer + StringBuilder + Wrappers\n");
        System.out.print("Ingresa tu nombre: ");
        String nombre = entrada.nextLine();
        //Se comprueba que el nombre no se encuentre vacío.
        //trim() permite eliminar espacios al principio y al final
        while (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            System.out.print("Ingresa tu nombre: ");
            nombre = entrada.nextLine();
        }
        // Se llama al método encargado de solicitar y validar la edad
        Integer edad = obtenerEdad(entrada);
        //Se llaman los métodos que trabajan con StringBuffer
        //y StringBuilder para obtener sus respectivos resultados
        String nombreBuffer = modificarConStringBuffer(nombre);
        String nombreBuilder = modificarConStringBuilder(nombre);

        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Nombre original: " + nombre);
        System.out.println("StringBuffer: " + nombreBuffer);
        System.out.println("StringBuilder: " + nombreBuilder);
        // Se muestra la edad almacenada en un objeto Integer
        System.out.println("Edad (Wrapper Integer): " + edad);
        // Se cierra Scanner porque ya no será utilizado
        entrada.close();import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Programa3 {

    // Pide la cantidad de nombres para guardar en la lista y verifica que sean string
    public static void llenarLista(ArrayList<String> lista, Scanner entrada) {

        int cantidad;

        // Valida que el numero ingresado este entre 1 y 20
        while (true) {

            System.out.print("¿Cuántos nombres deseas agregar? ");

            // Comprueba si es un numero entero
            if (entrada.hasNextInt()) {

                cantidad = entrada.nextInt();

                // Sale del ciclo si el numero esta en el rango
                if (cantidad > 0 && cantidad <= 20) {
                    break;
                }

                System.out.println("La cantidad debe estar entre 1 y 20.");

            } else {

                // Descarta la entrada si no es un numero entero
                System.out.println("Debes ingresar un número entero.");
                entrada.next();
            }
        }

        // Limpia el salto de linea que queda en el scanner
        entrada.nextLine();

        // Pide los nombres uno por uno segun la cantidad indicada
        for (int i = 0; i < cantidad; i++) {

            String nombre;

            // Pide el nombre y verifica que no este vacio
            do {

                System.out.print("Ingresa el nombre " + (i + 1) + ": ");
                nombre = entrada.nextLine().trim();

                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }

            } while (nombre.isEmpty());

            // Agrega el nombre a la lista
            lista.add(nombre);
        }
    }

    // Muestra los nombres del ArrayList con for-each
    public static void mostrarArrayList(ArrayList<String> lista) {

        System.out.println("\n===== ARRAYLIST =====");

        for (String nombre : lista) {
            System.out.println(nombre);
        }
    }

    // Muestra los nombres del LinkedList con for-each
    public static void mostrarLinkedList(LinkedList<String> lista) {

        System.out.println("\n===== LINKEDLIST =====");

        for (String nombre : lista) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== PROGRAMA 3 =====");
        System.out.println("ArrayList + LinkedList + For-each\n");

        // Crea la lista ArrayList
        ArrayList<String> nombresArrayList = new ArrayList<>();

        // Llama al metodo para llenar el ArrayList
        llenarLista(nombresArrayList, entrada);

        // Muestra el ArrayList
        mostrarArrayList(nombresArrayList);

        // Crea la lista LinkedList
        LinkedList<String> nombresLinkedList = new LinkedList<>();

        // Copia los elementos del ArrayList al LinkedList
        nombresLinkedList.addAll(nombresArrayList);

        // Muestra el LinkedList
        mostrarLinkedList(nombresLinkedList);

        // Cierra el scanner
        entrada.close();
    }
}
    }
}