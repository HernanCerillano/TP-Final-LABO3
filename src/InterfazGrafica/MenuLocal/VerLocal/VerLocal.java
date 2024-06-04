package InterfazGrafica.MenuLocal.VerLocal;

import InterfazGrafica.MenuLocal.MenuLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerLocal extends JFrame{

    public VerLocal(MenuLocal menuAnterior){
        super("Gestion del Local");

        this.menuAnterior = menuAnterior;

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
    }


    private void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

    private Local local;
    private MenuLocal menuAnterior;
    private JButton volverButton;
    private JPanel panel1;
    private JButton editarLocalButton;
    private JButton verLocalButton;
}