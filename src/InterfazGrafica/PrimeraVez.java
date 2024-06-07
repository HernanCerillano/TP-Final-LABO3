package InterfazGrafica;

import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraVez extends JFrame{

    private JTextField direccionText;
    private JTextField alturaText;
    private JTextField horariosText;
    private JPanel menuPrimera;
    private JButton agregarButton;
    private JButton salirDelProgramaButton;
    private JTextField telefonoText;
    private JTextField nombreText;
    private Local local;

    public PrimeraVez(){
        super("Menu de primera vez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menuPrimera);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarDatos()) {
                    local = cargarLocal();
                    cerrarPrograma();
                    abrirMenu();
                }
            }
        });
        salirDelProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPrograma();
            }
        });
    }

    private void cerrarPrograma(){
        this.setVisible(false);
        this.dispose();
    }

    private void abrirMenu(){
        JFrame frame = new Menu(local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private Local cargarLocal(){
        String nombre = nombreText.getText().trim();
        String telefono = telefonoText.getText().trim();
        String direccion = direccionText.getText().trim();
        int altura = Integer.parseInt(alturaText.getText().trim());
        String horarios = horariosText.getText().trim();
        Local local = new Local(nombre, telefono, direccion, altura, horarios);
        local.AgregarLocalAlArchivo();
        return local;
    }

    private boolean validarDatos() {
        if (nombreText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validarTelefono(telefonoText.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un teléfono válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (direccionText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una dirección válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!esEntero(alturaText.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una altura válida (entero).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (horariosText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un horario válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private boolean esEntero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
