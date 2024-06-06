package InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock;

import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajarOSubirStock extends JFrame implements InterfazGrafica {

    private Local local;
    private MenuDeStock menuAnterior;
    private JPanel mainPanel;
    private JButton volverButton;
    private JList list1;
    private JTextField prendaText;
    private JTextField colorText;
    private JTextField talleText;
    private JButton buscarPrendaButton;
    private JTextField stockText;
    private JButton actualizarStockButton;

    public BajarOSubirStock(MenuDeStock menuAnterior, Local local){
        super("Menu de Gestion del Stock");

        this.menuAnterior = menuAnterior;
        this.local = local;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });

        buscarPrendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarStockFinal();
            }
        });
        actualizarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirRopaFinal();
            }
        });
    }


    public void imprimirRopa(){
        DefaultListModel modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Ropa ropa: local.getStockRopa()){
            modelo.addElement(ropa.toString()+"\n");
        }
    }

    public void cambiarStockFinal(){
        try {
            cargar();
            JOptionPane.showMessageDialog(null, "Se cambio con exito");
            local.AgregarRopaAlArchivo();
        }catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Parece que se olvido llenar los datos... ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirRopaFinal(){
        try {
            local.ObtenerRopaDelArchivo();
            imprimirRopa();
        }catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay ropa en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void cargar(){
        int stock = Integer.parseInt(stockText.getText());
        String prenda = prendaText.getText().toUpperCase();
        String talleAux = talleText.getText().toUpperCase();
        Talle talle = Talle.valueOf(talleAux);
        String color = colorText.getText().toUpperCase();
        local.buscarRopa(color, prenda, talle, stock);
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }



}
