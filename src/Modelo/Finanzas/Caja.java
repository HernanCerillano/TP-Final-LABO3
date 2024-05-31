package Modelo.Finanzas;

import java.util.HashSet;

public class Caja {

    private double cajaInicial;//Con cuanto arranca la caja en ese dia
    private double recaudacion;
    private HashSet<Compra> comprasDelDia;

    public Caja() {
        this.recaudacion=0;
        this.comprasDelDia= new HashSet<>();
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public double getCajaInicial() {
        return cajaInicial;
    }


    public void agregarCompras(Compra c){
        this.comprasDelDia.add(c);
    }

    public double retirarDinero(double aRetirar){
        if(aRetirar<=cajaInicial){
            cajaInicial-=aRetirar;
        }
        return cajaInicial;
    }

    public void agregarDinero(double aAgregar){
        cajaInicial+=aAgregar;
    }

    public void agregarRecaudacion(double aAgregar){
        recaudacion+=aAgregar;
    }

}
