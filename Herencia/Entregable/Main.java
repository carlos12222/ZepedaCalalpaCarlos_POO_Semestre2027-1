import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Hacemos un objeto de tipo scanner
        Scanner sc = new Scanner(System.in);
        //Pedimos los datos al usuario
        System.out.println("Introduce el codigo del paquete");
        String codigoIngresado = sc.nextLine();
        //Le metemos los parametros al constructor
        System.out.println("Introduce el numero de kilometros");
        double kilometros = sc.nextInt();
        paqueteExpress paquete =  new paqueteExpress(codigoIngresado);
        //Lo probamos con el override
        paquete.mostrarRastreo();
        //Probamos el metodo pero con sobrecarga
        //Le pasamos los km
        int dias = paquete.calcularTiempoEntrega(kilometros);
        System.out.println("Tiempo de envio express " + dias + " dias");
        sc.close();
    }
}
