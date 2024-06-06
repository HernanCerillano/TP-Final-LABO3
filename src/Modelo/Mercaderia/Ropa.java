package Modelo.Mercaderia;

import Modelo.Excepciones.eSinStock;
import Modelo.Excepciones.eSinTalle;

import java.io.Serializable;

public class Ropa implements Serializable {

    private int stock;

    private String tipo;

    private Talle talle;

    private double precio;

    private String colorRopa;

    public Ropa() {
        this.stock = 0;
        this.tipo = "";
        this.talle = null;
        this.precio = 0;
        this.colorRopa = "";
    }

    public Ropa(int stock, String tipo, Talle talle, double precio, String colorRopa) {
        this.stock = stock;
        this.tipo = tipo;
        this.talle = talle;
        this.precio = precio;
        this.colorRopa = colorRopa;
    }
//////////////////////////////////////GETTER Y SETTERS///////////////////////////////////////
    public int getStock() {
        return stock;
    }

    public String getTipo() {
        return tipo;
    }

    public Talle getTalle() {
        return talle;
    }

    public double getPrecio() {
        return precio;
    }

    public String getColorRopa() {
        return colorRopa;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////METODOS//////////////////////////////////////////////


    @Override
    public String toString() {
        return "Ropa{" +
                "stock=" + stock +
                ", tipo='" + tipo + '\'' +
                ", talle='" + talle + '\'' +
                ", precio=" + precio +
                ", colorRopa='" + colorRopa + '\'' +
                '}';
    }

    public void bajarUnStock(){
        stock--;
    }

    @Override
    public boolean equals(Object obj) {
        boolean sonIguales = false;

        if(obj!=null){
            if(obj instanceof Ropa){
                Ropa aux = (Ropa) obj;
                if(aux.getTipo().equalsIgnoreCase(getTipo()) && aux.getTalle()==getTalle() && aux.getColorRopa().equalsIgnoreCase(getColorRopa())){
                    sonIguales=true;
                }
            }
        }

        return sonIguales;
    }

    public void validarStock(int stock) throws eSinStock {
        if (stock<=0) {
            throw new eSinStock("No hay mas stock");
        }
    }

    public void validarTalle(Talle talle) throws eSinTalle {
        if (this.talle!=talle) {
            throw new eSinTalle("Talle incorrecto");
        }
    }
}
