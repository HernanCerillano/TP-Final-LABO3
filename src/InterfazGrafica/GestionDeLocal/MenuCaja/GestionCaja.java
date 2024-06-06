package InterfazGrafica.GestionDeLocal.MenuCaja;

import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import InterfazGrafica.InterfazGrafica;
import Modelo.Finanzas.Caja;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionCaja extends JFrame implements InterfazGrafica {
    private JButton verRecaudacionButton;
    private JButton agregarDineroButton;
    private JButton sacarDineroButton;
    private JButton verActualizarHistorialDeButton;
    private JButton volverButton;
    private JPanel mainPanel;
    private JList list1;
    private JTextField agregarText;
    private JTextField sacarText;
    private Local local;
    private MenuDelLocal menuAnterior;

    public GestionCaja(MenuDelLocal menuAnterior, Local local){
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

        verRecaudacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, local.verRecaudacion());
            }
        });
        agregarDineroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double precio = Double.parseDouble(agregarText.getText());
                local.aumentarCaja(precio);
                local.AgregarLocalAlArchivo();
            }
        });
        sacarDineroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double precio = Double.parseDouble(agregarText.getText());
                local.bajarCaja(precio);
                local.AgregarLocalAlArchivo();
            }
        });
        verActualizarHistorialDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

    /*public void imprimirCaja(){
        DefaultListModel modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Caja caja: local.getCaja()){
            modelo.addElement(caja.toString()+"\n");
        }
    }*/




}
