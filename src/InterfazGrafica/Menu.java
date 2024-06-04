package InterfazGrafica;

import InterfazGrafica.MenuLocal.MenuLocal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    public Menu(){
        super("Menu Principal");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelMenu);
        gestionarLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        abrirMenuLocal();
                    }
                });

            }
        });
        salirDelProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPrograma();
            }
        });
    }
    private void abrirMenuLocal(){

        JFrame frame = new MenuLocal(this);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void cerrarPrograma(){
        this.setVisible(false);
        this.dispose();
    }
    private JLabel tituloMenu;
    private JButton gestionarLocalButton;
    private JButton realizarCompraButton;
    private JButton gestionarCajaButton;
    private JButton salirDelProgramaButton;
    private JPanel panelMenu;
}
