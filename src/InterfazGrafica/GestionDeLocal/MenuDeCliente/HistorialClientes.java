package InterfazGrafica.GestionDeLocal.MenuDeCliente;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import Modelo.Humanos.Cliente;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorialClientes extends JFrame implements InterfazGrafica {
    private JButton verHistorialDeClientesButton;
    private JButton exportarHistorialEnJSonButton;
    private JButton volverButton;
    private JList list1;
    private JPanel mainPanel;
    private Local local;
    private MenuDelLocal menuAnterior;

    public HistorialClientes(MenuDelLocal menuAnterior, Local local){
        super("Menu de alta o baja de empleados");

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

        verHistorialDeClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirClientesFinal();
            }
        });
        exportarHistorialEnJSonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.exportarClientes();
                JOptionPane.showMessageDialog(null, "Se exporto con exito");
            }
        });
    }

    public void imprimirClientes(){
        DefaultListModel modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Cliente cli : local.getClientes()){
                modelo.addElement(cli.toString());
        }
    }
    public void imprimirClientesFinal(){
        try {
            local.ObtenerClientesDelArchivo();
            imprimirClientes();
        }catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay clientes en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }


}
