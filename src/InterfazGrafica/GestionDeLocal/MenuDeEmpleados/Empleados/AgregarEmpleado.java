package InterfazGrafica.GestionDeLocal.MenuDeEmpleados.Empleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDeEmpleados.GestionEmpleado;
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

    public AgregarEmpleado(GestionEmpleado menuAnterior, Local local) {
        super("Agregar empleados");

        this.local = local;
        this.menuAnterior = menuAnterior;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(400, 300); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana

        atrasButton.addActionListener(e -> volverAtras());
        agregarButton.addActionListener(e -> {
            if (validarDatos()) {
                local.agregarEmpleado(cargar());
                JOptionPane.showMessageDialog(null, "Se agregó con éxito");
                local.AgregarEmpleadosAlArchivo();
            }
        });
    }

    private boolean validarDatos() {
        if (nombreText.getText().isEmpty() || contieneNumeros(nombreText.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (apellidoText.getText().isEmpty() || contieneNumeros(apellidoText.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un apellido válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validarDNI(dniText.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!esDouble(salarioText.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un salario válido.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (horarioText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un horario válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarDNI(String input) {
        return input.matches("\\d{8}");
    }

    private boolean esDouble(String input) {
        return input.matches("-?\\d*\\.?\\d+");
    }

    private boolean contieneNumeros(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public Empleado cargar() {
        String nombre = nombreText.getText().trim();
        String apellido = apellidoText.getText().trim();
        String dni = dniText.getText().trim();
        double salario = Double.parseDouble(salarioText.getText().trim());
        String horario = horarioText.getText().trim();

        return new Empleado(nombre, apellido, dni, salario, horario);
    }

    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
