import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Reservacion {
    private int anio;
    private int mes;
    private int diaDelMes;
    private int diaDelAnio;
    private String diaSemana;
    private int hora;
    private boolean disponible;
    private String reservadoPor;

    public Reservacion(int anio, int mes, int diaDelMes, int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Error: La hora debe estar entre 0 y 23.");
        }
        LocalDate fecha = LocalDate.of(anio, mes, diaDelMes);
        this.anio = fecha.getYear();
        this.mes = fecha.getMonthValue();
        this.diaDelMes = fecha.getDayOfMonth();
        this.diaDelAnio = fecha.getDayOfYear();
        
        DayOfWeek dow = fecha.getDayOfWeek();
        this.diaSemana = dow.getDisplayName(TextStyle.FULL, Locale.of("es", "MX"));
        
        this.hora = hora;
        this.disponible = true;
        this.reservadoPor = "DISPONIBLE";
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public int getDiaDelMes() {
        return diaDelMes;
    }

    public int getDiaDelAnio() {
        return diaDelAnio;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public int getHora() {
        return hora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getReservadoPor() {
        return reservadoPor;
    }

    public void asignarReserva(String nombreCliente) {
        if (!this.disponible) {
            throw new IllegalStateException(
                "Error: La casilla del " + formatearFechaCorta() + " (" + diaSemana + 
                ", día del año " + diaDelAnio + ") a las " + hora + 
                ":00 ya está reservada por '" + reservadoPor + "'."
            );
        }
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre de la empresa o persona no puede estar vacío.");
        }
        this.reservadoPor = nombreCliente.trim();
        this.disponible = false;
    }

    public String generarClave() {
        return String.format("%04d-%02d-%02d-%02d", anio, mes, diaDelMes, hora);
    }

    public String formatearFechaCorta() {
        return String.format("%02d/%02d/%04d", diaDelMes, mes, anio);
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "No disponible";
        return "Fecha: " + formatearFechaCorta() + 
               " | Dia del año: " + diaDelAnio + 
               " | Dia: " + diaSemana + 
               " | Hora: " + hora + ":00" + 
               " | Estado: " + estado + 
               " | Reservado por: " + reservadoPor;
    }
}