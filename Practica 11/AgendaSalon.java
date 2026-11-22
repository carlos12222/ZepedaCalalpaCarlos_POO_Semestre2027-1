import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Map;
import java.util.TreeMap;

public class AgendaSalon {
    private String nombreSalon;
    private Map<String, Reservacion> casillas;
    private static final String ARCHIVO_AGENDA = "agenda_salon_calendario.txt";

    public AgendaSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
        this.casillas = new TreeMap<>();
    }

    private Reservacion obtenerOCrearCasilla(int anio, int mes, int diaDelMes, int hora) {
        String clave = String.format("%04d-%02d-%02d-%02d", anio, mes, diaDelMes, hora);
        if (!casillas.containsKey(clave)) {
            casillas.put(clave, new Reservacion(anio, mes, diaDelMes, hora));
        }
        return casillas.get(clave);
    }

    public void realizarReservacion(int anio, int mes, int diaDelMes, int hora, String empresaOPersona) {
        try {
            if (hora < 0 || hora > 23) {
                throw new IllegalArgumentException("Error: La hora debe estar entre 0 y 23.");
            }
            Reservacion casilla = obtenerOCrearCasilla(anio, mes, diaDelMes, hora);
            casilla.asignarReserva(empresaOPersona);
            System.out.println("Reserva exitosa -> " + casilla);
        } catch (DateTimeException ex) {
            System.out.println("Error de calendario: Fecha invalida (" + diaDelMes + "/" + mes + "/" + anio + ").");
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarAgenda() {
        System.out.println("\nAGENDA DEL SALON: " + nombreSalon);
        if (casillas.isEmpty()) {
            System.out.println("No hay registros en la agenda.");
            return;
        }
        for (Reservacion r : casillas.values()) {
            System.out.println(r);
        }
    }

    public void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_AGENDA))) {
            for (Reservacion r : casillas.values()) {
                bw.write(
                    r.getAnio() + ";" +
                    r.getMes() + ";" +
                    r.getDiaDelMes() + ";" +
                    r.getHora() + ";" +
                    r.isDisponible() + ";" +
                    r.getReservadoPor()
                );
                bw.newLine();
            }
            System.out.println("Agenda guardada en '" + ARCHIVO_AGENDA + "'.");
        } catch (IOException ex) {
            System.out.println("Error al guardar la agenda en archivo: " + ex.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_AGENDA))) {
            casillas.clear(); // Evita choques si ya había datos cargados en memoria
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 6) {
                    int anio = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int diaDelMes = Integer.parseInt(partes[2]);
                    int hora = Integer.parseInt(partes[3]);
                    boolean disp = Boolean.parseBoolean(partes[4]);
                    String cliente = partes[5];

                    Reservacion casilla = obtenerOCrearCasilla(anio, mes, diaDelMes, hora);
                    if (!disp) {
                        casilla.asignarReserva(cliente);
                    }
                }
            }
            System.out.println("Agenda cargada desde '" + ARCHIVO_AGENDA + "'.");
        } catch (IOException ex) {
            System.out.println("Nota: No se pudo leer el archivo previo (" + ex.getMessage() + ").");
        }
    }
}