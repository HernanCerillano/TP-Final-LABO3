package InterfazGrafica.GestionDeLocal.MenuDeEmpleados.Empleados;

import InterfazGrafica.InterfazGrafica;
import InterfazGrafica.GestionDeLocal.MenuDeEmpleados.GestionEmpleado;
import Modelo.Local;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarEmpleado extends JFrame implements InterfazGrafica {
    private JTextField idText;
    private JTextField apellidoText;
    private JTextField salarioText;
    private JButton volverButton;
    private JButton editarButton;
    private JButton buscarEmpleadoButton;
    private JPanel panel1;
    private JTextField dniText;
    private JTextField nombreText;
    private JTextField horarioText;
    private GestionEmpleado menuAnterior;
    private Local local;
    private int id;

    public EditarEmpleado(GestionEmpleado menuAnterior, Local local){

        super("Editar los empleados");

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

        buscarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(idText.getText());
                if(local.buscarIdEmpleado(id)){
                    JOptionPane.showMessageDialog(null, "Se encontro el empleado.\n Ya puede editar su informacion");
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro al empleado.\n Puede volver a intentarlo");
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarEmpleado();
            }
        });


    }
    public void editarEmpleado() {
        String nombre = nombreText.getText().trim();
        String apellido = apellidoText.getText().trim();
        String dni = dniText.getText().trim();
        String salarioStr = salarioText.getText().trim();
        String horario = horarioText.getText().trim();

        if (nombre.isEmpty() && apellido.isEmpty() && dni.isEmpty() && salarioStr.isEmpty() && horario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se proporcionaron datos para editar.");
        }

        try {
            if (!nombre.isEmpty()) {
                local.editarNombreEmpleado(id, nombre);
            }
            if (!apellido.isEmpty()) {
                local.editarApellidoEmpleado(id, apellido);
            }
            if (!dni.isEmpty()) {
                local.editarDNIEmpleado(id, dni);
            }
            if (!salarioStr.isEmpty()) {
                double salario = Double.parseDouble(salarioStr);
                local.editarSalarioEmpleado(id, salario);
            }
            if (!horario.isEmpty()) {
                local.editarHorariosEmpleado(id, horario);
            }

            local.AgregarEmpleadosAlArchivo();
            JOptionPane.showMessageDialog(null, "Se editó con éxito al empleado");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El salario debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void volverAtras(){
        menuAnterior.setVisible(true);
        this.dispose();
    }

}
