package InterfazGrafica.GestionDeLocal.MenuCaja;

import InterfazGrafica.GestionDeLocal.MenuDelLocal;
import InterfazGrafica.InterfazGrafica;
import Modelo.Finanzas.Caja;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class GestionCaja extends JFrame implements InterfazGrafica {
    private JButton verRecaudacionButton;
    private JButton agregarDineroButton;
    private JButton sacarDineroButton;
    private JButton verActualizarHistorialDeButton;
    private JButton volverButton;
    private JPanel mainPanel;
    private JList<String> list1;
    private JTextField agregarText;
    private JTextField sacarText;
    private Local local;
    private MenuDelLocal menuAnterior;

    public GestionCaja(MenuDelLocal menuAnterior, Local local) {
        super("Menu de Gestion del Stock");

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

        verRecaudacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, local.getRecaudacion());
            }
        });

        agregarDineroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double agregar = Double.parseDouble(agregarText.getText());
                    local.agregarRecaudacion(agregar);
                    JOptionPane.showMessageDialog(null, "Se agregó con éxito");
                    local.AgregarLocalAlArchivo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido");
                }
            }
        });

        sacarDineroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double retirar = Double.parseDouble(sacarText.getText());
                    local.retirarDinero(retirar);
                    JOptionPane.showMessageDialog(null, "Se retiró con éxito");
                    local.AgregarLocalAlArchivo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido");
                }
            }
        });

        verActualizarHistorialDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirMovimientos();
            }
        });
    }

    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }

    public void imprimirMovimientos() {
        Caja caja = local.getCaja();
        DefaultListModel<String> modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();

        Map<String, Double> ingresosPorFecha = caja.getIngresosPorFecha();
        for (Map.Entry<String, Double> entry : ingresosPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double cantidad = entry.getValue();
            modelo.addElement("Ingreso - Fecha: " + fecha + ", Cantidad: " + cantidad);
        }

        Map<String, Double> retirosPorFecha = caja.getRetirosPorFecha();
        for (Map.Entry<String, Double> entry : retirosPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double cantidad = entry.getValue();
            modelo.addElement("Retiro - Fecha: " + fecha + ", Cantidad: " + cantidad);
        }
    }
}







