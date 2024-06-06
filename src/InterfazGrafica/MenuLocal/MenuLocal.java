package InterfazGrafica.MenuLocal;

import InterfazGrafica.Menu;
import InterfazGrafica.MenuLocal.VerLocal.VerLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLocal extends JFrame{
    private Menu menuAnterior;
    private JButton historialDeClientesButton;
    private JButton volverAlMenuPrincipalButton;
    private JButton gestionarStockDeRopaButton;
    private JButton gestionarEmpleadosButton;
    private JButton verLocalButton;
    private JPanel mainPanel;
    private Local local;

    public MenuLocal(Menu menuAnterior, Local local){
        super("Menu de Gestion General");
        this.local=local;
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
                abrirVerLocal(local);
            }
        });
    }


    public void abrirVerLocal(Local local){

        JFrame frame = new VerLocal(this, local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }


}
