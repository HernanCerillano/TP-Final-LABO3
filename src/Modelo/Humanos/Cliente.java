package Modelo.Humanos;

import Modelo.Finanzas.Compra;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Compra> historialCompras;
    private Compra compra;

    public Cliente (){
        super();
        this.historialCompras= new ArrayList<>();
        this.compra=new Compra();
    }

    public Cliente(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.historialCompras = new ArrayList<>();
    }

    public ArrayList<Compra> getHistorialCompras() {
        return historialCompras;
    }
    public void setCompra(Compra e){
        this.compra=e;
    }
    public void agregarAlHistorialDeCompras(Compra e){
        this.historialCompras.add(e);
    }

    public String mostrarHistorial (){
        String info="\nHistorial de Compras: \n\n";
        for(Compra com : historialCompras){
            info+="Fecha de Compra: "+com.getFechaDeCompra()+"\n"+com.getItemsComprados()+"\n";
        }
        return info;
    }

    @Override
    public String toString() {
        return super.toString()+"\n\n"+mostrarHistorial()+"\n";

    }



}
