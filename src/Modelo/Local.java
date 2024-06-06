package Modelo;

import Modelo.Datos.Archivo;
import Modelo.Excepciones.eSinStock;
import Modelo.Finanzas.Caja;
import Modelo.Finanzas.Compra;
import Modelo.Humanos.Cliente;
import Modelo.Humanos.Empleado;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Local implements Serializable{
    private static final long serialVersionUID = -862208884450743488L;
    private String direccion;
    private int altura;
    private String horarios;
    private Caja caja;
    private ArrayList<Ropa> stockRopa;
    private HashSet<Empleado> empleados;
    private HashSet<Cliente> clientes;

    public Local() {
        this.direccion = "";
        this.altura = 0;
        this.horarios = "";
        this.caja=new Caja();
        this.stockRopa=new ArrayList<>();
        this.empleados= new HashSet<>();
        this.clientes= new HashSet<>();
    }
    public Local(String direccion, int altura, String horarios) {
        this.direccion = direccion;
        this.altura = altura;
        this.horarios = horarios;
        this.caja=new Caja();
        this.stockRopa=new ArrayList<>();
        this.empleados= new HashSet<>();
        this.clientes= new HashSet<>();
    }

///////////////////////////GETTERS Y SETTERS///////////////////////////////////////////////
    public String getDireccion() {
        return direccion;
    }
    public int getAltura() {
        return altura;
    }
    public String getHorarios() {
        return horarios;
    }
    public ArrayList<Ropa> getStockRopa() {
        return stockRopa;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
    public HashSet<Empleado> getEmpleados() {
        return empleados;
    }
    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////METODOS////////////////////////////////////////////////////

    public String imprimirInformacionDelLocal (){
        return "Direccion: "+getDireccion()+" "+getAltura()+"\nHorarios: "+getHorarios()+"\n";
    }
    private int obtenerUltimoIdEmpleado() {
        int maxId = 0;
        for (Empleado emp : empleados) {
            if (emp.getId() > maxId) {
                maxId = emp.getId();
            }
        }
        return maxId;
    }
    public void agregarEmpleado(Empleado e){
        e.setId(obtenerUltimoIdEmpleado()+1);
        this.empleados.add(e);
    }
    public String imprimirEmpleados(){
        String info="";

        for(Empleado emp : this.empleados){
            if (emp.isDisponible()){
                info+= emp.toString()+"\n";
            }
        }
        return info;
    }
    public String imprimirEmpleadosDadosDeBaja(){
        String info="";

        for(Empleado emp : this.empleados){
            if (!emp.isDisponible()){
                info+= emp.toString()+"\n";
            }
        }
        return info;
    }
    private int obtenerUltimoIdCliente() {
        int maxId = 0;
        for (Cliente cli : clientes) {
            if (cli.getId() > maxId) {
                maxId = cli.getId();
            }
        }
        return maxId;
    }
    public void agregarCliente(Cliente c){
        c.setId(obtenerUltimoIdCliente()+1);
        this.clientes.add(c);
    }
    public void agregarRopaAlStock (Ropa r){
        this.stockRopa.add(r);
    }
    public String mostrarStockRopa() {
        String info="";
        int i=0;
        for(Ropa ro : this.stockRopa){
            info+="["+i+"] "+ro.getTipo()+", "+ro.getTalle()+", "+ro.getColorRopa()+" | $"+ro.getPrecio()+"\n";
            i++;
        }
        return info;
    }
    public void procesarCompra(Compra c){
        this.caja.agregarCompras(c);
    }
    public void comprarUnaRopa(Ropa ropa){
        try{
            ropa.validarStock(ropa.getStock());
            ropa.bajarUnStock();
            caja.agregarDinero(ropa.getPrecio());
            caja.agregarRecaudacion(ropa.getPrecio());
        }catch (eSinStock e){
            e.printStackTrace();
        }
    }
    public void darDeBajaEmpleado(int ID){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && emp.getId()==ID){
                emp.setDisponible(false);
            }
        }
    }
    public void darDeAltaEmpleado(int ID){
        for(Empleado emp : this.empleados){
            if(!emp.isDisponible() && emp.getId()==ID){
                emp.setDisponible(true);
            }
        }
    }
    public boolean verificarDisponibilidad (Talle talle, String tipo){
        boolean encontrado = false;

        for(Ropa ropa : this.stockRopa){
            if(ropa.getTalle()==talle && ropa.getTipo().equalsIgnoreCase(tipo)){
                if(ropa.getStock()>0){
                    encontrado=true;
                }
            }
        }

        return encontrado;
    }
    public void editarNombreCompletoEmpleado(int ID,String nombre, String Apellido){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setNombre(nombre);
                emp.setApellido(Apellido);
            }
        }
    }
    public void editarApellidoEmpleado(int ID, String Apellido){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setApellido(Apellido);
            }
        }
    }

    public void editarNombreEmpleado(int ID,String nombre){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setNombre(nombre);
            }
        }
    }


    public void editarDniEmpleado(int ID,String dni){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setDni(dni);
            }
        }
    }

    public void editarSalarioEmpleado(int ID,double salario){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setSalario(salario);

            }
        }
    }
    public void editarHorariosEmpleado(int ID,String Horario){
        for(Empleado emp : this.empleados){
            if(emp.isDisponible() && ID==emp.getId()){
                emp.setHorarios(Horario);

            }
        }
    }
    public void cambiarDisponibilidad(int id){
        for(Empleado emp : this.empleados){
            if(id==emp.getId()){
                boolean aux = emp.isDisponible();
                if(true==aux){
                    emp.setDisponible(false);
                }else{
                    emp.setDisponible(true);
                }
            }
        }
    }
    public boolean hayEmpleadosDadosDeBaja() {
        boolean hayDadosDeBaja = false;
        for (Empleado empleado : empleados) {
            if (!empleado.isDisponible()) {
                hayDadosDeBaja = true;
            }
        }
        return hayDadosDeBaja;
    }
    public boolean buscarIdEmpleado (int ID){
        boolean rta=false;
        for(Empleado emp : this.empleados){
            if(emp.getId()==ID){
                rta=true;
            }
        }
        return rta;
    }
    public Empleado buscarEmpleadoPorId(int id){
        Empleado empleado=null;
        for (Empleado emp : this.empleados){
            if(emp.getId()==id){
                empleado=emp;
            }
        }
        return empleado;
    }

    public Cliente buscarClientePorDni(String DNI){
        Cliente cliente=null;
        for (Cliente cli : this.clientes){
            if(cli.getDni().equals(DNI)){
                cliente=cli;
            }
        }
        return cliente;
    }
    public String imprimirClientes(){
        String info="";
        for(Cliente cli : this.clientes){
            info+=cli.toString()+"\n";
        }
        return info;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////MANEJO ARCHIVOS////////////////////////////////////////////////////

    public void AgregarLocalAlArchivo() {
        Archivo<Local> archivo = new Archivo<>();
        archivo.escribirArchivo(new File("Informacion_Local.dat"), this);
    }

    public Local ObtenerLocalDelArchivo() {
        Archivo<Local> archivo = new Archivo<>();
        Local local = archivo.leerArchivo(new File("Informacion_Local.dat"));
        if (local == null) {
            local = new Local();
        }
        return local;
    }

    public void AgregarRopaAlArchivo() {

        Archivo<ArrayList<Ropa>> archivo = new Archivo<>();
        archivo.escribirArchivo(new File("Stock_De_Ropa.dat"), this.stockRopa);
    }

    public void ObtenerRopaDelArchivo() {
        Archivo<ArrayList<Ropa>> archivo = new Archivo<>();
        this.stockRopa = archivo.leerArchivo(new File("Stock_De_Ropa.dat"));
        if (this.stockRopa == null) {
            this.stockRopa = new ArrayList<>();
        }
    }

    public void AgregarEmpleadosAlArchivo() {
        Archivo<HashSet<Empleado>> archivo = new Archivo<>();
        archivo.escribirArchivo(new File("Registro_Empleados.dat"), this.empleados);
    }

    public void ObtenerEmpleadosDelArchivo() {
        Archivo<HashSet<Empleado>> archivo = new Archivo<>();
        this.empleados = archivo.leerArchivo(new File("Registro_Empleados.dat"));
        if (this.empleados == null) {
            this.empleados = new HashSet<>();
        }
    }

    public void AgregarClientesAlArchivo() {
        Archivo<HashSet<Cliente>> archivo = new Archivo<>();
        archivo.escribirArchivo(new File("Registro_Clientes.dat"), this.clientes);
    }

    public void ObtenerClientesDelArchivo() {
        Archivo<HashSet<Cliente>> archivo = new Archivo<>();
        this.clientes = archivo.leerArchivo(new File("Registro_Clientes.dat"));
        if (this.clientes == null) {
            this.clientes = new HashSet<>();
        }
    }
}
