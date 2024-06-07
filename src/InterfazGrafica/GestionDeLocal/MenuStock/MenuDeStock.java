package InterfazGrafica.GestionDeLocal.MenuStock;

import InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock.AgregarYVerStock;
import InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock.BajarOSubirStock;
import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import InterfazGrafica.InterfazGrafica;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDeStock extends JFrame implements InterfazGrafica {
    private JButton agregarYVerElButton;
    private JButton modificarElStockButton;
    private JButton exportarAJSonElButton;
    private JButton volverButton;
    private JPanel mainPanel;
    private Local local;
    private MenuDelLocal menuAnterior;

    public MenuDeStock(MenuDelLocal menuAnterior, Local local){
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

        agregarYVerElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAgregarStock(local);
            }
        });
        exportarAJSonElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.exportarStockRopa();
                JOptionPane.showMessageDialog(null, "Se exporto con exito");
            }
        });
        modificarElStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAltaYBajaStock(local);
            }
        });
    }
    public void abrirAgregarStock(Local local){

        JFrame frame = new AgregarYVerStock(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void abrirAltaYBajaStock(Local local){

        JFrame frame = new BajarOSubirStock(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }



}
