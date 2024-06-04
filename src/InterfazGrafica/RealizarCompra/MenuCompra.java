package InterfazGrafica.RealizarCompra;

import InterfazGrafica.InterfazGrafica;
import Modelo.Local;
import InterfazGrafica.Menu;
import Modelo.Mercaderia.Ropa;
import Modelo.Finanzas.Compra;
import Modelo.Humanos.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuCompra extends JFrame implements InterfazGrafica {
    private JButton comprarButton;
    private JButton devolucionButton;
    private JButton volverButton;
    private JList<String> carrritoList;
    private JTextField eliminarText;
    private JButton eliminarDelCarritoButton;
    private JList<String> stockList;
    private JTextField agregarText;
    private JButton agregarAlCarritoButton;
    private JPanel mainPanel;
    private Local local;
    private ElegirCliente menuAnterior;
    private List<Ropa> carrito;
    private String dni;

    public MenuCompra(ElegirCliente menuAnterior, Local local, String dni) {
        super("Menu de Gestion del Stock");

        this.menuAnterior = menuAnterior;
        this.local = local;
        this.carrito = new ArrayList<>();
        this.dni = dni;

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null); // Centrar la ventana


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            realizarCompraFinal();
            }
        });

        eliminarDelCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDelCarrito();
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlCarrito();
            }
        });
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


    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }

    private void imprimirCarrito() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        carrritoList.setModel(modelo);
        modelo.removeAllElements();
        for (Ropa ropa : carrito) {
            if(ropa.isDisponibilidad() && ropa.getStock()>0) {
                modelo.addElement(ropa.toString() + "\n");
            }
        }
    }

    private void imprimirRopa() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        stockList.setModel(modelo);
        modelo.removeAllElements();
        for (Ropa ropa : local.getStockRopa()) {
            modelo.addElement(ropa.toString() + "\n");
        }
    }

    private Ropa elegirIdRopa() {
        try {
            int id = Integer.parseInt(agregarText.getText());
            return local.buscarRopaPorId(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
            return null;
        }
    }

    private void agregarAlCarrito() {
        Ropa ropa = elegirIdRopa();
        if (ropa != null) {
            carrito.add(ropa);
            local.bajarStockRopa(ropa.getId());
            imprimirRopa();
            imprimirCarrito();
        } else {
            JOptionPane.showMessageDialog(null, "ID de ropa no válido.");
        }
    }

    private void eliminarDelCarrito() {
        try {
            int id = Integer.parseInt(eliminarText.getText());
            Ropa ropaAEliminar = null;
            for (Ropa ropa : carrito) {
                if (ropa.getId() == id) {
                    ropaAEliminar = ropa;
                    break;
                }
            }
            if (ropaAEliminar != null) {
                carrito.remove(ropaAEliminar);
                local.aumentarStockRopa(ropaAEliminar.getId());
                imprimirRopa();
                imprimirCarrito();
            } else {
                JOptionPane.showMessageDialog(null, "ID de ropa no encontrado en el carrito.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
        }
    }

    public void realizarCompraFinal(){
        try {
            realizarCompra();
            local.AgregarLocalAlArchivo();

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Algo fallo en la compra...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarCompra() {
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío.");
            return;
        }

        HashMap<Ropa, Integer> itemsComprados = new HashMap<>();
        for (Ropa ropa : carrito) {
            itemsComprados.put(ropa, itemsComprados.getOrDefault(ropa, 0) + 1);
        }

        Compra compra = new Compra(itemsComprados);

        Cliente cliente = local.buscarClientePorDni(dni);
        cliente.agregarAlHistorialDeCompras(compra);

        local.agregarRecaudacion(compra.getTotal());

        carrito.clear();
        imprimirCarrito();
        compra.crearPDF(local, cliente);
        JOptionPane.showMessageDialog(null, "Compra realizada con éxito.\nTotal: $" + compra.getTotal());
        local.agregarCliente(cliente);
        local.AgregarClientesAlArchivo();
    }
}
