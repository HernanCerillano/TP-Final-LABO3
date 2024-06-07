
import InterfazGrafica.Menu;
import InterfazGrafica.PrimeraVez;
import Modelo.Humanos.Cliente;
import Modelo.Finanzas.Compra;
import Modelo.Humanos.Empleado;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Local local = new Local();
        local = local.ObtenerLocalDelArchivo();
        if (local == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new PrimeraVez();
                    frame.setSize(1000, 600);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                }
            });
        } else {
            Local finalLocal = local;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new Menu(finalLocal);
                    frame.setSize(1000, 600);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                }
            });
        }

    }
}