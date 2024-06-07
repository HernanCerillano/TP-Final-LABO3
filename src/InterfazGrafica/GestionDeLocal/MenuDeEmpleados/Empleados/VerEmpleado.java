package InterfazGrafica.GestionDeLocal.MenuDeEmpleados.Empleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDeEmpleados.GestionEmpleado;
import Modelo.Humanos.Empleado;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerEmpleado extends JFrame implements InterfazGrafica {

    private GestionEmpleado menuAnterior;
    private Local local;
    private JPanel mainPanel;
    private JButton button1;
    private JList probando;
    private JButton verEmpleadosButton;


    public VerEmpleado(GestionEmpleado menuAnterior, Local local){
        super("Ver empleados");

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

        //modelo.addElement();
        verEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.ObtenerEmpleadosDelArchivo();
                imprimirEmpleados();
            }
        });
    }

    public void imprimirEmpleados(){
        DefaultListModel modelo = new DefaultListModel<>();
        probando.setModel(modelo);
        modelo.removeAllElements();
        for(Empleado emp : local.getEmpleados()){
            if (emp.isDisponible()){
                modelo.addElement(emp.toString()+"\n");
            }
        }
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
