package InterfazGrafica.GestionDeLocal.MenuStock.OpcionesDeStock;

import InterfazGrafica.GestionDeLocal.MenuStock.MenuDeStock;
import InterfazGrafica.InterfazGrafica;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajarOSubirStock extends JFrame implements InterfazGrafica {

    private Local local;
    private MenuDeStock menuAnterior;
    private JPanel mainPanel;
    private JButton volverButton;
    private JList<String> list1;
    private JTextField idText;
    private JTextField stockText;
    private JButton buscarPrendaButton;
    private JButton actualizarStockButton;

    public BajarOSubirStock(MenuDeStock menuAnterior, Local local){
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

        buscarPrendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarStock();
            }
        });

        actualizarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaDeRopa();
            }
        });

        // Inicializar lista de ropa al iniciar
        actualizarListaDeRopa();
    }

    public void actualizarListaDeRopa(){
        try {
            local.ObtenerRopaDelArchivo();
            imprimirRopa();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay ropa en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirRopa(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Ropa ropa : local.getStockRopa()){
            modelo.addElement(ropa.toString());
        }
    }

    public void cambiarStock(){
        try {
            int stock = Integer.parseInt(stockText.getText());
            int id = Integer.parseInt(idText.getText());
            local.buscarRopaYSumarStock(id, stock);
            JOptionPane.showMessageDialog(null, "Se cambió el stock con éxito");
            local.AgregarRopaAlArchivo();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Parece que se olvidó llenar los datos... ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
