package InterfazGrafica;

import InterfazGrafica.MenuLocal.MenuLocal;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimerMenu extends JFrame{

    private JPanel panelMenu;
    private JTextField direccionText;
    private JTextField alturaText;
    private JTextField horarioText;
    private JButton agregarButton;
    private Local local;

    public PrimerMenu()
    {
        super("Primer Menu");
        this.local=local;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelMenu);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                local=cargarLocal();
                abrirMenuPrincipal(local);
                cerrarPrograma();
            }
        });
    }

    private Local cargarLocal()
    {
        String direccion=direccionText.getText();
        int altura=Integer.parseInt(alturaText.getText());
        String horario=horarioText.getText();
        local=new Local(direccion, altura, horario);
        return local;
    }
    private void cerrarPrograma(){
        this.setVisible(false);
        this.dispose();
    }
    private void abrirMenuPrincipal(Local local){

        JFrame frame = new Menu(this,local);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        this.setVisible(false);
    }


}

