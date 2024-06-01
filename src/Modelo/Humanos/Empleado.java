package Modelo.Humanos;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    private double salario;
    private boolean disponible;
    private String horarios;

    public Empleado (){
        super();
        this.salario = 0;
        this.disponible=false;
        this.horarios ="";
    }

    public Empleado(String nombre, String apellido, String dni, double salario, String horarios) {
        super(nombre, apellido, dni);
        this.salario = salario;
        this.disponible=true;
        this.horarios = horarios;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return super.toString()+" Salario = " + salario + ", Disponible? = " + disponible + ", Horarios ='" + horarios + "\n";
    }
}
