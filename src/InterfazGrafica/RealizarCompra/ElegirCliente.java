package InterfazGrafica.RealizarCompra;

import InterfazGrafica.InterfazGrafica;
import Modelo.Humanos.Empleado;
import Modelo.Local;
import InterfazGrafica.Menu;
import Modelo.Humanos.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;

public class ElegirCliente extends JFrame implements InterfazGrafica {
    private JPanel mainPanel;
    private JTextField nombreText;
    private JTextField apellidoText;
    private JTextField dniText;
    private JList<String> list1;
    private JButton actualizarButton;
    private JTextField dniText2;
    private JButton siguienteButton;
    private JButton volverButton;
    private Local local;
    private Menu menuAnterior;


    public ElegirCliente(Menu menuAnterior, Local local) {
        super("Menu Principal");
        this.local = local;
        this.menuAnterior = menuAnterior;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(1000, 600);
        setLocationRelativeTo(null); // Centrar la ventana

        volverButton.addActionListener(e -> volverAtras());
        siguienteButton.addActionListener(e -> abrirMenuCompra());
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreText.getText();
                String apellido = apellidoText.getText();
                String dni = dniText.getText();
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor carga todos los datos.");
                }else {
                    Cliente cliente = new Cliente(nombre, apellido, dni);
                    local.agregarCliente(cliente);
                    local.AgregarClientesAlArchivo();
                }
                actualizarListaDeClientes();
            }
        });
        actualizarListaDeClientes();
    }

    public void actualizarListaDeClientes(){
        try {
            local.ObtenerClientesDelArchivo();
            imprimirClientes();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No hay clientes en el archivo, no se puede imprimir nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirClientes(){
        DefaultListModel modelo = new DefaultListModel<>();
        list1.setModel(modelo);
        modelo.removeAllElements();
        for(Cliente cli : local.getClientes()){
            modelo.addElement(" "+cli.getDni()+" "+ cli.getNombre()+" "+ cli.getApellido()+"\n");
        }
    }

    private void abrirMenuCompra() {
        String dni = dniText2.getText().trim();
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente != null) {
            abrirNuevaVentana(new MenuCompra(this, local, cliente.getDni()));
        } else {
            JOptionPane.showMessageDialog(this, "DNI no encontrado. Por favor, ingrese un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Cliente buscarClientePorDni(String dni) {
        Cliente clienteFinal = null;
        HashSet<Cliente> clientes = local.getClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clienteFinal = cliente;
            }
        }
        return clienteFinal;
    }

    private void abrirNuevaVentana(JFrame frame) {
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    @Override
    public void volverAtras() {
        menuAnterior.setVisible(true);
        this.dispose();
    }
}
