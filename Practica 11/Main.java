import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaSalon agenda = new AgendaSalon("Salon Real");
        agenda.cargarDesdeArchivo();

        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\n--- MENU DE AGENDA DEL SALON ---");
            System.out.println("1. Realizar una reservacion");
            System.out.println("2. Ver agenda actual");
            System.out.println("3. Guardar agenda en archivo");
            System.out.println("4. Cargar agenda desde archivo");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Anio (ej. 2026): ");
                        int anio = scanner.nextInt();
                        System.out.print("Mes (1 a 12): ");
                        int mes = scanner.nextInt();
                        System.out.print("Dia del mes (1 a 31): ");
                        int diaDelMes = scanner.nextInt();
                        System.out.print("Hora (0 a 23): ");
                        int hora = scanner.nextInt();
                        scanner.nextLine(); // Limpiar salto de línea
                        System.out.print("Nombre de la empresa o persona: ");
                        String cliente = scanner.nextLine();

                        agenda.realizarReservacion(anio, mes, diaDelMes, hora, cliente);
                        break;
                    case 2:
                        agenda.mostrarAgenda();
                        break;
                    case 3:
                        agenda.guardarEnArchivo();
                        break;
                    case 4:
                        agenda.cargarDesdeArchivo();
                        break;
                    case 5:
                        agenda.guardarEnArchivo();
                        ejecutando = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intenta con un numero del 1 al 5.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error de entrada: Debes ingresar un numero valido.");
                scanner.nextLine(); // Limpiar entrada inválida
            }
        }
        scanner.close();
    }
}