package InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock;

import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import Modelo.Excepciones.eEmpleadoNoEncontrado;
import Modelo.Excepciones.eRopaNoEncontrada;
import Modelo.Humanos.Empleado;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisponibilidadRopa extends JFrame implements InterfazGrafica {

    private Local local;
    private MenuDeStock menuAnterior;
    private JPanel mainPanel;
    private JButton volverButton;
    private JList bajaList;
    private JList altaList;
    private JButton cambiarButton;
    private JTextField idText;
    private JButton verListasButton;

    public DisponibilidadRopa(MenuDeStock menuAnterior, Local local) {
        super("Menu de baja y alta stock");
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

        verListasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local.ObtenerRopaDelArchivo();
                imprimirRopaDeBaja();
                imprimirRopaDeAlta();

            }
        });
        cambiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiar();
            }
        });
    }

    public void imprimirRopaDeAlta() {
        DefaultListModel modelo = new DefaultListModel<>();
        altaList.setModel(modelo);
        modelo.removeAllElements();
        for (Ropa rop : local.getStockRopa()) {
            if (true == rop.isDisponibilidad()) {
                modelo.addElement(rop.getId() + " " + rop.getTipo() + " " + rop.getColorRopa()+ " "+ rop.getPrecio());
            }
        }
    }

    public void imprimirRopaDeBaja() {
        DefaultListModel modelo = new DefaultListModel<>();
        bajaList.setModel(modelo);
        modelo.removeAllElements();
        for (Ropa rop : local.getStockRopa()) {
            if (false == rop.isDisponibilidad()) {
                modelo.addElement(rop.getId() + " " + rop.getTipo() + " " + rop.getColorRopa()+ " "+ rop.getPrecio());
            }
        }
    }

    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }

    public void cambiar() {
        int id = Integer.parseInt(idText.getText());
        try {
            local.cambiarDisponibilidadRopa(id);
        } catch (eRopaNoEncontrada e) {
            throw new RuntimeException(e);
        }
        local.AgregarRopaAlArchivo();
        JOptionPane.showMessageDialog(null, "Se cambio con exito al empleado");
    }
}