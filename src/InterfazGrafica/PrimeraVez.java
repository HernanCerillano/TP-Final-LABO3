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
    private Local local;

    public PrimeraVez(){
        super("Menu de primera vez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menuPrimera);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            local = cargarLocal();
            cerrarPrograma();
            abrirMenu();
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

        JFrame frame = new Menu(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private Local cargarLocal(){
        String direccion = direccionText.getText();
        int altura = Integer.parseInt(alturaText.getText());
        String horarios = horariosText.getText();
        Local local = new Local(direccion, altura, horarios);
        return local;
    }
}
