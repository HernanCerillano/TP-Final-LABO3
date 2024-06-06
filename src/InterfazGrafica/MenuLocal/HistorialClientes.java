package InterfazGrafica.MenuLocal;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.GestionEmpleado;
import Modelo.Humanos.Cliente;
import Modelo.Humanos.Empleado;
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
    private MenuLocal menuAnterior;

    public HistorialClientes(MenuLocal menuAnterior, Local local){
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
                local.ObtenerClientesDelArchivo();
                imprimirClientes();
            }
        });
        exportarHistorialEnJSonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Se exporto con exito");
            }
        });
    }

    public void imprimirClientes(){
        DefaultListModel modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Cliente cli : local.getClientes()){
                modelo.addElement(cli.getDni() + cli.getNombre() + cli.getApellido());
        }
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }


}
