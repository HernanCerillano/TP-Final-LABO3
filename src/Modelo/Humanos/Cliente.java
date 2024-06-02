package Modelo.Humanos;

import Modelo.Finanzas.Compra;

import java.util.ArrayList;

public class Cliente extends Persona {

    private double historialCompras;
    private ArrayList<Compra> compras;

    public Cliente (){
        super();
        this.historialCompras= 0;
        this.compras=new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, String dni, double historialCompras) {
        super(nombre, apellido, dni);
        this.historialCompras = historialCompras;
        this.compras=new ArrayList<>();
    }

    public double getHistorialCompras() {
        return historialCompras;
    }
    public void agregarCompra(Compra e){
        this.compras.add(e);
    }
    public void setHistorialCompras(float historialCompras) {
        this.historialCompras = historialCompras;
    }
    public ArrayList<Compra> getCompras() {
        return compras;
    }
    public String imprimirCompras (){
        String info="";
        for(Compra com : this.compras){
            info+=com.getItemsComprados();
        }
        return info;
    }
    @Override
    public String toString() {
        return super.toString()+" Compras: "+imprimirCompras()+"\n";

    }
}
