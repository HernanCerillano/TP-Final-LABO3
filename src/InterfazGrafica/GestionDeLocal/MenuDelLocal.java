package InterfazGrafica.GestionDeLocal;

import InterfazGrafica.GestionDeLocal.MenuCaja.GestionCaja;
import InterfazGrafica.GestionDeLocal.MenuDeEmpleados.GestionEmpleado;
import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.Menu;
import InterfazGrafica.GestionDeLocal.MenuDeCliente.HistorialClientes;
import InterfazGrafica.GestionDeLocal.VerLocal.VerLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDelLocal extends JFrame implements InterfazGrafica {
    private Menu menuAnterior;
    private JButton historialDeClientesButton;
    private JButton volverAlMenuPrincipalButton;
    private JButton gestionarStockDeRopaButton;
    private JButton gestionarEmpleadosButton;
    private JButton verLocalButton;
    private JPanel mainPanel;
    private JButton manejarCajaButton;
    private Local local;

    public MenuDelLocal(Menu menuAnterior, Local local){
        super("Menu de Gestion General");
        this.local=local;
        this.menuAnterior = menuAnterior;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        volverAlMenuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        verLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVerLocal(local);
            }
        });
        gestionarEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            abrirGestionEmpleados(local);
            }
        });
        historialDeClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirHistorialClientes(local);
            }
        });
        gestionarStockDeRopaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirGestionDeStock(local);
            }
        });
        manejarCajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirManejoDeCaja(local);
            }
        });
    }


    public void abrirVerLocal(Local local){

        JFrame frame = new VerLocal(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void abrirGestionEmpleados(Local local){

        JFrame frame = new GestionEmpleado(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void abrirHistorialClientes(Local local){

        JFrame frame = new HistorialClientes(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void abrirGestionDeStock(Local local){

        JFrame frame = new MenuDeStock(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void abrirManejoDeCaja(Local local){

        JFrame frame = new GestionCaja(this, local);
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
