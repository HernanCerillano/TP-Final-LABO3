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
                local.setNombre(nombreText.getText());
                local.setTelefono(telefonoText.getText());
                local.setDireccion(direccionText.getText());
                local.setAltura(Integer.parseInt(alturaText.getText()));
                local.setHorarios(horarioText.getText());
                local.AgregarLocalAlArchivo();
            }
        });
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

}
