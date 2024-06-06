package InterfazGrafica.MenuLocal.MenuDeEmpleados.Empleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.MenuLocal.MenuDeEmpleados.GestionEmpleado;
import Modelo.Humanos.Empleado;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarEmpleado extends JFrame implements InterfazGrafica {

    private JTextField nombreText;
    private JTextField apellidoText;
    private JTextField dniText;
    private JTextField salarioText;
    private JTextField horarioText;
    private JPanel mainPanel;
    private JButton agregarButton;
    private JButton atrasButton;
    private GestionEmpleado menuAnterior;
    private Local local;

    public AgregarEmpleado(GestionEmpleado menuAnterior, Local local){
        super("Agregar empleados");

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
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.agregarEmpleado(cargar());
                JOptionPane.showMessageDialog(null, "Se agrego con exito");
                local.AgregarEmpleadosAlArchivo();
            }
        });
    }

    public Empleado cargar(){
        String nombre = nombreText.getText();
        String apellido = apellidoText.getText();
        String dni = dniText.getText();
        double salario = Double.parseDouble(salarioText.getText());
        String horario = horarioText.getText();
        Empleado emp = new Empleado(nombre, apellido, dni, salario, horario);
        return emp;
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
