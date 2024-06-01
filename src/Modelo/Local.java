package Modelo;

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

public class Local {

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

    public String mostrarStockRopa() {
        String info="";
        int i=0;
        for(Ropa ro : this.stockRopa){
            info+="["+i+"] "+ro.getTipo()+", "+ro.getTalle()+", "+ro.getColorRopa()+" | $"+ro.getPrecio()+"\n";
            i++;
        }
        return info;
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

    public String imprimirEmpleados(){
        String info="";

        for(Empleado emp : this.empleados){
            info+= emp.toString()+"\n";

        }
        return info;
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////METODOS////////////////////////////////////////////////////


    public void agregarEmpleado(Empleado e){
        this.empleados.add(e);
    }

    public void agregarCliente(Cliente e){
        this.clientes.add(e);
    }

    public void agregarRopaAlStock (Ropa r){
        this.stockRopa.add(r);
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

    public void bajarUnEmpleado(Empleado emp){
        emp.setDisponible(false);
    }

    public void subirUnEmpleado(Empleado emp){
        emp.setDisponible(true);
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

    public void AgregarRopaAlArchivo (){
        ObjectOutputStream objectOutputStream = null;
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("Stock_De_Ropa.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Ropa ro : this.stockRopa) {
                objectOutputStream.writeObject(ro);
            }

        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                objectOutputStream.close();
            }
            catch (IOException ex)
            {

            }

        }
    }
    public void ObtenerRopaDelArchivo (){
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("Stock_De_Ropa.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            this.stockRopa.clear();

            while (true) {
                Ropa ropa = (Ropa) objectInputStream.readObject();
                this.stockRopa.add(ropa);

            }


        } catch (EOFException ex)
        {

        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                objectInputStream.close();
            }
            catch (IOException ex)
            {

            }

        }
    }

}
