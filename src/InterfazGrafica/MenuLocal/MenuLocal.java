package InterfazGrafica.MenuLocal;

import InterfazGrafica.Menu;
import InterfazGrafica.MenuLocal.VerLocal.VerLocal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLocal extends JFrame{

    public MenuLocal(Menu menuAnterior){
        super("Menu de Gestion General");

        this.menuAnterior = menuAnterior;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        volverAlMenuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        verLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVerLocal();
            }
        });
    }


    private void abrirVerLocal(){

        JFrame frame = new VerLocal(this);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

    private Menu menuAnterior;
    private JButton historialDeClientesButton;
    private JButton volverAlMenuPrincipalButton;
    private JButton gestionarStockDeRopaButton;
    private JButton gestionarEmpleadosButton;
    private JButton verLocalButton;
    private JPanel mainPanel;

}
