package InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock;

import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarYVerStock extends JFrame implements InterfazGrafica {

    private Local local;
    private MenuDeStock menuAnterior;
    private JPanel mainPanel;
    private JList<String> list1;
    private JButton actualizarButton;
    private JTextField stockText;
    private JTextField prendaText;
    private JTextField talleText;
    private JTextField precioText;
    private JTextField colorText;
    private JButton volverButton;

    public AgregarYVerStock(MenuDeStock menuAnterior, Local local) {
        super("Menu de Gestion del Stock");

        this.menuAnterior = menuAnterior;
        this.local = local;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        volverButton.addActionListener(e -> volverAtras());

        actualizarButton.addActionListener(e -> {
            if (validarDatos()) {
                agregarRopa();
                actualizarListaDeRopa();
            }
        });

        // Inicialización de la lista de ropa
        actualizarListaDeRopa();
    }

    public void imprimirRopa() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for (Ropa ropa : local.getStockRopa()) {
            modelo.addElement(ropa.toString());
        }
    }

    public void actualizarListaDeRopa() {
        try {
            local.ObtenerRopaDelArchivo();
            imprimirRopa();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay ropa en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarRopa() {
        try {
            Ropa nuevaRopa = cargarRopaDesdeCampos();
            local.agregarRopaAlStock(nuevaRopa);
            JOptionPane.showMessageDialog(null, "Se agregó con éxito");
            local.AgregarRopaAlArchivo();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Parece que se olvidó llenar los datos...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Ropa cargarRopaDesdeCampos() {
        int stock = Integer.parseInt(stockText.getText().trim());
        String prenda = prendaText.getText().trim().toUpperCase();
        String talleAux = talleText.getText().trim().toUpperCase();
        Talle talle = Talle.valueOf(talleAux);
        double precio = Double.parseDouble(precioText.getText().trim());
        String color = colorText.getText().trim().toUpperCase();
        return new Ropa(stock, prenda, talle, precio, color);
    }

    private boolean validarDatos() {
        if (!esEntero(stockText.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un stock válido (entero).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (prendaText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una prenda válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validarTalle(talleText.getText().trim().toUpperCase())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un talle válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!esDouble(precioText.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio válido (número).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (colorText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un color válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean esEntero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarTalle(String input) {
        try {
            Talle.valueOf(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
