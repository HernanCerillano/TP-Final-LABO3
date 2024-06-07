package Modelo.Finanzas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Caja implements Serializable {

    private double recaudacion;
    private HashMap<String, Double> retirosPorFecha;
    private HashMap<String, Double> ingresosPorFecha;

    public Caja() {
        this.recaudacion = 0;
        this.retirosPorFecha = new HashMap<>();
        this.ingresosPorFecha = new HashMap<>();
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    private String calcularFecha() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaActual.format(formatter);
    }

    public void retirarDinero(double aRetirar) {
        if (aRetirar <= recaudacion) {
            recaudacion -= aRetirar;
            String fechaActual = calcularFecha();
            retirosPorFecha.put(fechaActual, retirosPorFecha.getOrDefault(fechaActual, 0.0) + aRetirar);
        }
    }

    public void agregarRecaudacion(double aAgregar) {
        recaudacion += aAgregar;
        String fechaActual = calcularFecha();
        ingresosPorFecha.put(fechaActual, ingresosPorFecha.getOrDefault(fechaActual, 0.0) + aAgregar);
    }

    public Map<String, Double> getRetirosPorFecha() {
        return retirosPorFecha;
    }

    public Map<String, Double> getIngresosPorFecha() {
        return ingresosPorFecha;
    }

    public String obtenerRetirosPorFecha() {
        StringBuilder retiros = new StringBuilder("Retiros por Fecha:\n");
        for (Map.Entry<String, Double> entry : retirosPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double cantidad = entry.getValue();
            retiros.append("Fecha: ").append(fecha).append(", Cantidad Retirada: ").append(cantidad).append("\n");
        }
        return retiros.toString();
    }

    public String obtenerIngresosPorFecha() {
        StringBuilder ingresos = new StringBuilder("Ingresos por Fecha:\n");
        for (Map.Entry<String, Double> entry : ingresosPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double cantidad = entry.getValue();
            ingresos.append("Fecha: ").append(fecha).append(", Cantidad Ingresada: ").append(cantidad).append("\n");
        }
        return ingresos.toString();
    }
}
