package InterfazGrafica;

import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import InterfazGrafica.RealizarCompra.ElegirCliente;
import InterfazGrafica.RealizarCompra.MenuCompra;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JLabel tituloMenu;
    private JButton gestionarLocalButton;
    private JButton realizarCompraButton;
    private JButton salirDelProgramaButton;
    private JPanel panelMenu;
    private Local local;

    public Menu(Local local) {
        super("Menu Principal");
        this.local = local;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelMenu);
        setSize(1000, 600);
        setLocationRelativeTo(null); // Centrar la ventana

        gestionarLocalButton.addActionListener(e -> abrirMenuLocal());
        salirDelProgramaButton.addActionListener(e -> cerrarPrograma());
        realizarCompraButton.addActionListener(e -> abrirMenuCompra());
    }

    private void abrirMenuLocal() {
        abrirNuevaVentana(new MenuDelLocal(this, local));
    }

    public void abrirMenuCompra() {
        abrirNuevaVentana(new ElegirCliente(this, local));
    }

    private void abrirNuevaVentana(JFrame frame) {
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Centrar la nueva ventana
        this.setVisible(false);
    }

    private void cerrarPrograma() {
        this.setVisible(false);
        this.dispose();
    }

}
