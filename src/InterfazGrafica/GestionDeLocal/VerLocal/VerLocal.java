package InterfazGrafica.GestionDeLocal.VerLocal;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerLocal extends JFrame implements InterfazGrafica {
    private Local local;
    private MenuDelLocal menuAnterior;
    private JButton volverButton;
    private JPanel panel1;
    private JButton editarLocalButton;
    private JButton verLocalButton;
    private JTextField direccionText;
    private JTextField horarioText;
    private JTextField alturaText;
    private JTextField nombreText;
    private JTextField telefonoText;

    public VerLocal(MenuDelLocal menuAnterior, Local local){
        super("Gestion del Local");

        this.menuAnterior = menuAnterior;
        this.local=local;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        verLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, local.imprimirInformacionDelLocal());
            }
        });
        editarLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarLocal();
            }
        });
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

    private Local cargarLocal(){
        String nombre = nombreText.getText().trim();
        String telefono = telefonoText.getText().trim();
        String direccion = direccionText.getText().trim();
        int altura = Integer.parseInt(alturaText.getText().trim());
        String horarios = horarioText.getText().trim();
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
        if (horarioText.getText().trim().isEmpty()) {
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
