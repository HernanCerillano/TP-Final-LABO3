package Modelo.Humanos;

public abstract class Persona {

    protected int id;
    private static int contadorId = 1;
    private String nombre;
    private String apellido;
    private String dni;

    public Persona() {
        this.id=contadorId++;
        this.nombre="";
        this.apellido="";
        this.dni="";
    }

    public Persona(String nombre, String apellido, String dni) {
        this.id=contadorId++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "ID = " + id + ", Nombre = '" + nombre + '\'' + ", Apellido = '" + apellido + '\'' + ", DNI = '" + dni + '\'';
    }
}
