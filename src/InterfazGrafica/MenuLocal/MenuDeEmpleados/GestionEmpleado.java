package InterfazGrafica.MenuLocal.MenuDeEmpleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.Empleados.AgregarEmpleado;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.Empleados.CambiarDisponibilidad;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.Empleados.EditarEmpleado;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.Empleados.VerEmpleado;
import InterfazGrafica.MenuLocal.MenuLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionEmpleado extends JFrame implements InterfazGrafica {

    private JButton verEmpleadosButton;
    private JButton editarInfoDeEmpleadosButton;
    private JButton atrasButton;
    private JButton statusButton;
    private JButton agregarEmpleadoButton;
    private JPanel mainPanel;
    private MenuLocal menuAnterior;
    private Local local;

    public GestionEmpleado(MenuLocal menuAnterior, Local local){
        super("Gestion de empleados");

        this.local=local;
        this.menuAnterior = menuAnterior;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        verEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVerEmpleados();
            }
        });
        agregarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAgregarEmpleados();
            }
        });
        editarInfoDeEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEditarEmpleados();
            }
        });
        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAltaYBajaDeEmpleados();
            }
        });
    }

    private void abrirAgregarEmpleados(){

        JFrame frame = new AgregarEmpleado(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void abrirVerEmpleados(){

        JFrame frame = new VerEmpleado(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void abrirEditarEmpleados(){

        JFrame frame = new EditarEmpleado(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void abrirAltaYBajaDeEmpleados(){

        JFrame frame = new CambiarDisponibilidad(this, local);
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
