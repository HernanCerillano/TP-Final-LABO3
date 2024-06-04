package InterfazGrafica;

import InterfazGrafica.MenuLocal.MenuLocal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraVez extends JFrame{

    public PrimeraVez(){
        super("Menu de primera vez");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menuPrimera);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccion = direccionText.getText();
                int altura = Integer.parseInt(alturaText.getText());
                String horarios = horariosText.getText();
            }
        });
    }


    private void abrirMenu(){

        JFrame frame = new Menu(this);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private JTextField direccionText;
    private JTextField alturaText;
    private JTextField horariosText;
    private JPanel menuPrimera;
    private JButton agregarButton;
}
