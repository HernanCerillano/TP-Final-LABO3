package InterfazGrafica.GestionDeLocal.MenuDeEmpleados.Empleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDeEmpleados.GestionEmpleado;
import Modelo.Humanos.Empleado;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarDisponibilidad extends JFrame implements InterfazGrafica {
    private JList listaAlta;
    private JList listaBaja;
    private JButton verEmpleadosButton;
    private JTextField cambiarDispText;
    private JPanel mainPanel;
    private JButton button1;
    private JButton cambiarButton;
    private Local local;
    private GestionEmpleado menuAnterior;

    public CambiarDisponibilidad(GestionEmpleado menuAnterior, Local local){
        super("Menu de alta o baja de empleados");

        this.menuAnterior = menuAnterior;
        this.local = local;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });

        verEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.ObtenerEmpleadosDelArchivo();
                imprimirEmpleadosDeAlta();
                imprimirEmpleadosDeBaja();
            }
        });
        cambiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(cambiarDispText.getText());
                local.cambiarDisponibilidad(id);
                local.AgregarEmpleadosAlArchivo();
                JOptionPane.showMessageDialog(null, "Se cambio con exito al empleado");
            }
        });
    }

    public void imprimirEmpleadosDeAlta(){
        DefaultListModel modelo = new DefaultListModel<>();
        listaAlta.setModel(modelo);
        modelo.removeAllElements();
        for(Empleado emp : local.getEmpleados()){
            if (emp.isDisponible()){
                modelo.addElement(emp.getId());
            }
        }
    }

    public void imprimirEmpleadosDeBaja(){
        DefaultListModel modelo = new DefaultListModel<>();
        listaBaja.setModel(modelo);
        modelo.removeAllElements();
        for(Empleado emp : local.getEmpleados()){
            if (false==emp.isDisponible()){
                modelo.addElement(emp.getId());
            }
        }
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

}
