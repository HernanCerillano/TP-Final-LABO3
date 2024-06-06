package InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock;

import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarYVerStock extends JFrame implements InterfazGrafica {

    private Local local;
    private MenuDeStock menuAnterior;
    private JPanel mainPanel;
    private JList list1;
    private JButton actualizarButton;
    private JTextField stockText;
    private JTextField prendaText;
    private JTextField talleText;
    private JTextField precioText;
    private JTextField colorText;
    private JButton volverButton;
    private JButton actualizarListaButton;

    public AgregarYVerStock(MenuDeStock menuAnterior, Local local){
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
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirRopaFinal();
            }
        });
        actualizarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarRopaFinal();
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

    public void imprimirRopaFinal(){
        try {
            local.agregarRopaAlStock(cargar());
            JOptionPane.showMessageDialog(null, "Se agrego con exito");
            local.AgregarRopaAlArchivo();
        }catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Parece que se olvido llenar los datos... ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarRopaFinal(){
        try {
            local.ObtenerRopaDelArchivo();
            imprimirRopa();
        }catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay ropa en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Ropa cargar(){
        int stock = Integer.parseInt(stockText.getText());
        String prenda = prendaText.getText().toUpperCase();
        String talleAux = talleText.getText().toUpperCase();
        Talle talle = Talle.valueOf(talleAux);
        double precio = Double.parseDouble(precioText.getText());
        String color = colorText.getText().toUpperCase();
        Ropa ropa = new Ropa(stock, prenda, talle, precio, color);
        return ropa;
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }



}
