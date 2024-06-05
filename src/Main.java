
import InterfazGrafica.PrimeraVez;
import Modelo.Humanos.Cliente;
import Modelo.Finanzas.Compra;
import Modelo.Humanos.Empleado;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Local local;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PrimeraVez();
                frame.setSize(1000, 600);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });

       /* Local local = new Local();
        local = local.ObtenerLocalDelArchivo();

        if (local == null) {

            local=ingresarInformacionInicial();

        }
        local.AgregarLocalAlArchivo();

        menu(local);
*/
}
    public static Local ingresarInformacionInicial() {

        System.out.println("\nBienvenido! Parece que es la primera vez que ejecutas el programa.\n");
        System.out.println("\nPor favor, ingresa la información del local.\n");

        System.out.print("Dirección: \n");
        String direccion = scanner.nextLine();


        System.out.print("Altura: \n");
        int altura = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Horarios: \n");
        String horarios = scanner.nextLine();

        Local local=new Local(direccion,altura,horarios);

        return local;

    }
    public static void menu(Local local){

    boolean salir=false;

    while(!salir) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.println("\n- Menú Principal: \n");
        System.out.println("[1] Gestionar Local\n");
        System.out.println("[2] Realizar Compra\n");
        System.out.println("[3] Salir\n");
        System.out.print("Ingrese su opción: ");

        int opcion = scanner.nextInt();
        System.out.println("\n");
        switch (opcion) {
            case 1:
                subMenuGestionDelLocal(local);
                break;
            case 2:
                menuRealizarCompra(local);
                break;
            case 3:
                salir=true;
                System.out.println("\nSaliendo del programa....\n");
                break;
            default:
                System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                System.out.println("\n\n\n\n");
                break;
        }
    }
    }
    public static void subMenuGestionDelLocal (Local local){
        boolean salir=false;

        while(!salir){
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n-- Gestion del Local: \n");
            System.out.println("[1] Gestionar la informacion del Local\n");
            System.out.println("[2] Gestionar Empleados\n");
            System.out.println("[3] Gestionar el Historial de Clientes del Local\n");
            System.out.println("[4] Gestionar el Stock de Ropa\n");
            System.out.println("[5] Volver al Menu Principal\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion){
            case 1:
                subMenuInformacionDelLocal(local);
                break;
            case 2:
                subMenuGestionEmpleados(local);
                break;
            case 3:
                subMenuGestionClientesLocal (local);
                break;
            case 4:
                subMenuGestionStockLocal(local);
                break;
            case 5:
                salir=true;
                break;
            default:
                System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                System.out.println("\n\n\n\n");
                break;
        }
        }
    }
    public static void subMenuInformacionDelLocal(Local local) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n--- Informacion del Local: \n");

            System.out.println("[1] Ver la informacion del Local\n");
            System.out.println("[2] Editar la informacion del Local\n");
            System.out.println("[3] Volver al Menu de Gestion del Local\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion) {
                case 1:

                    local=local.ObtenerLocalDelArchivo();
                    System.out.println(local.imprimirInformacionDelLocal());
                    break;
                case 2:
                    boolean salirAux = false;
                    while (!salirAux) {
                        System.out.println("\n---------------------------------------------------\n");
                        System.out.println("\n---- Editar Informacion del Local: \n");
                        System.out.println("[1] Editar la Direccion\n");
                        System.out.println("[2] Editar el Horario\n");
                        System.out.println("[3] Volver al Menu de Informacion del Local\n");
                        System.out.print("Ingrese su opción: ");
                        int opcionAux = scanner.nextInt();
                        switch (opcionAux) {
                            case 1:
                                System.out.println("La Actual Direccion es : " + local.getDireccion() + " " + local.getAltura() + ", Por cual desea cambiarla?\n");
                                System.out.println("Calle: ");
                                scanner.nextLine();
                                String nuevaDire = scanner.nextLine();
                                System.out.println("Altura: ");
                                int nuevaAltu = scanner.nextInt();
                                scanner.nextLine();
                                local.setDireccion(nuevaDire);
                                local.setAltura(nuevaAltu);
                                local.AgregarLocalAlArchivo();
                                break;
                            case 2:
                                System.out.println("El horario actual es : " + local.getHorarios() +", Por cual desea cambiarlo?\n");
                                System.out.println("Nuevo Horario: ");
                                scanner.nextLine();
                                String nuevoHorario = scanner.nextLine();
                                local.setHorarios(nuevoHorario);
                                local.AgregarLocalAlArchivo();
                                break;
                            case 3:
                                salirAux=true;
                                break;
                            default:
                                System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                                System.out.println("\n\n\n\n");
                                break;
                        }
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
        }
    }
    public static void subMenuGestionEmpleados(Local local){
        boolean salir=false;

        while(!salir){
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n--- Gestion de Empleados: \n");
            System.out.println("[1] Ingresar un Nuevo Empleado\n");
            System.out.println("[2] Ver Empleados\n");
            System.out.println("[3] Editar Informacion de Empleados\n");
            System.out.println("[4] Dar de Baja un Empleado\n");
            System.out.println("[5] Dar de Alta un Empleado\n");
            System.out.println("[6] Volver al Menu de Gestion del Local \n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion){
                case 1:
                    cargarEmpleadosAlLocal(local);
                    break;
                case 2:
                    local.ObtenerEmpleadosDelArchivo();
                    System.out.println(local.imprimirEmpleados());
                    break;
                case 3:
                    local.ObtenerEmpleadosDelArchivo();
                    System.out.println(local.imprimirEmpleados());
                    System.out.println("Ingrese el ID del Empleado que desea editar: ");
                    int editar= scanner.nextInt();
                    boolean salirAux = false;
                    while (!salirAux) {
                        System.out.println("\n---------------------------------------------------\n");
                        System.out.println("\n---- Editar Informacion de Empleado: \n");
                        System.out.println("[1] Editar el Nombre y Apellido\n");
                        System.out.println("[2] Editar el Horario\n");
                        System.out.println("[3] Modificar el Salario\n");
                        System.out.println("[4] Volver al Menu de Gestion de Empleados\n");
                        System.out.print("Ingrese su opción: ");
                        int opcionAux = scanner.nextInt();
                        System.out.println("\n");
                        switch (opcionAux) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevoNombre=scanner.nextLine();
                                System.out.println("Ingrese el nuevo apellido: ");
                                String nuevoApellido=scanner.nextLine();
                                local.editarNombreCompletoEmpleado(editar,nuevoNombre,nuevoApellido);
                                local.AgregarEmpleadosAlArchivo();
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("Ingrese el nuevo horario: ");
                                String nuevoHorario=scanner.nextLine();
                                local.editarHorariosEmpleado(editar,nuevoHorario);
                                local.AgregarEmpleadosAlArchivo();
                                break;
                            case 3:
                                System.out.println("Ingrese el nuevo salario: ");
                                double nuevoSalario=scanner.nextDouble();
                                local.editarSalarioEmpleado(editar,nuevoSalario);
                                local.AgregarEmpleadosAlArchivo();
                                break;
                            case 4:
                                salirAux=true;
                                break;
                            default:
                                System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                                System.out.println("\n\n\n\n");
                                break;
                        }
                    }
                    break;
                case 4:
                        local.ObtenerEmpleadosDelArchivo();
                        System.out.println(local.imprimirEmpleados());
                        System.out.println("Ingrese el ID del Empleado que desea dar de Baja: ");
                        int darDeBaja = scanner.nextInt();
                         if (!local.buscarIdEmpleado(darDeBaja)) {
                        System.out.println("El ID ingresado no es válido. No se puede dar de baja a un empleado.");
                        } else {
                             local.darDeBajaEmpleado(darDeBaja);
                             local.AgregarEmpleadosAlArchivo();
                             System.out.println("\nAccion Realizada con Exito! ");
                         }
                    break;
                case 5:
                    if (!local.hayEmpleadosDadosDeBaja()) {
                        System.out.println("No hay empleados dados de baja para dar de alta.");
                    } else {
                        local.ObtenerEmpleadosDelArchivo();
                        System.out.println(local.imprimirEmpleadosDadosDeBaja());
                        System.out.println("Ingrese el ID del Empleado que desea dar de Alta: ");
                        int darDeAlta = scanner.nextInt();
                        if (!local.buscarIdEmpleado(darDeAlta)) {
                            System.out.println("El ID ingresado no es válido. No se puede dar de alta a un empleado.");
                        } else {
                        local.darDeAltaEmpleado(darDeAlta);
                        local.AgregarEmpleadosAlArchivo();
                        System.out.println("\nAccion Realizada con Exito! ");
                    }
                    }
                    break;
                case 6:
                    salir=true;
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
    }
    }
    public static void subMenuGestionClientesLocal (Local local){
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n--- Gestion de Clientes del Local: \n");
            System.out.println("[1] Ver el Historial de Clientes del Local\n");
            System.out.println("[2] Exportar el Historial de Clientes del Local en Formarto .JSON\n");
            System.out.println("[3] Volver al Menu de Gestion del Local\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion) {
                case 1:
                    local.ObtenerClientesDelArchivo();
                    System.out.println(local.imprimirClientes());
                    break;
                case 2:

                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
        }
    }
    public static void subMenuGestionStockLocal (Local local){
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n--- Gestion de Stock del Local: \n");
            System.out.println("[1] Ingresar Ropa al Stock\n");
            System.out.println("[2] Ver el Stock Disponible\n");
            System.out.println("[3] Dar de Baja Ropa del Stock\n");
            System.out.println("[4] Dar de Alta Ropa del Stock\n");
            System.out.println("[5] Exportar el Stock de Ropa en Formarto .JSON\n");
            System.out.println("[6] Volver al Menu de Gestion del Local\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion) {
                case 1:
                    cargarRopaAlStock(local);
                    break;
                case 2:
                    local.ObtenerRopaDelArchivo();
                    System.out.println(local.mostrarStockRopa());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
            }
    }
    public static void subMenuRealizarCompra(Local local, Cliente cliente, Compra compra){
        boolean salir=false;

        while(!salir){
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n-- Gestion de la Compra: \n");
            System.out.println("[1] Ver la Lista de Compra\n");
            System.out.println("[2] Editar Lista de Compra\n");
            System.out.println("[3] Procesar la Compra\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion){
                case 1:
                    System.out.println(compra.getItemsComprados());
                    break;
                case 2:

                    break;
                case 3:
                    salir=true;
                    cliente.setCompra(compra);
                    cliente.agregarAlHistorialDeCompras(compra);
                    local.agregarCliente(cliente);
                    local.AgregarClientesAlArchivo();
                    compra.crearPDF(local,cliente);
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
            }
    }
    public static void menuRealizarCompra(Local local){

        scanner.nextLine();

        System.out.println("Ingrese el DNI: ");
        String buscarDni= scanner.nextLine();

        local.ObtenerClientesDelArchivo();

        Cliente cliente=local.buscarClientePorDni(buscarDni);

        if(cliente==null) {
            cliente = agregarCliente();
        }
        else{
            System.out.println(cliente.mostrarHistorial());
        }

        ArrayList<Ropa>lista=crearListaDeCompras(local);

        Compra compra= new Compra(lista,new Empleado());

        subMenuRealizarCompra(local,cliente,compra);

    }
    public static Ropa agregarRopa(){
        System.out.println("Dime el stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Dime el tipo de prenda: ");
        String prenda = scanner.nextLine();
        System.out.println("Dime el talle (XS, S, M, L, XL, XXL): ");
        String talleAux = scanner.nextLine().toUpperCase();
        Talle talle = Talle.valueOf(talleAux);
        System.out.println("Dime el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Dime el color de la prenda: ");
        String color = scanner.nextLine();
        Ropa ropaAux = new Ropa(stock, prenda, talle, precio, color);
        return ropaAux;
    }
    public static void cargarRopaAlStock(Local localAux){
        int op = 0;
        while(op==0){
            localAux.agregarRopaAlStock(agregarRopa());
            System.out.println("Desea agregar otra prenda?\n(Escribi 0 si queres)");
            op=scanner.nextInt();
        }
        localAux.AgregarRopaAlArchivo();
    }
    public static Empleado crearEmpleado(){
        scanner.nextLine();
        System.out.println("Dime el apellido");
        String apellido = scanner.nextLine();

        System.out.println("Dime el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime el dni");
        String dni = scanner.nextLine();

        System.out.println("Dime el horario: ");
        String horario = scanner.nextLine();

        System.out.println("Dime el salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Empleado emp = new Empleado(nombre, apellido, dni, salario, horario);

        return emp;
    }
    public static void cargarEmpleadosAlLocal (Local localAux){
        int op = 0;
        System.out.println("------Inicio Registro Empleado------\n");
        while(op==0){
            Empleado emp=crearEmpleado();
            localAux.agregarEmpleado(emp);
            System.out.println("------Empleado Registrado Exitosamente!------\n");
            System.out.println("Desea agregar otro Empleado?\n(Escribi 0 si queres)");
            op=scanner.nextInt();
        }
        localAux.AgregarEmpleadosAlArchivo();
    }
    public static Cliente agregarCliente(){
        System.out.println("------Inicio Registro Cliente------\n");

        System.out.println("Dime el apellido");
        String apellido = scanner.nextLine();

        System.out.println("Dime el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime el dni");
        String dni = scanner.nextLine();

        Cliente cliente = new Cliente (nombre, apellido, dni);
        System.out.println("------Cliente Registrado Exitosamente!------\n");
        return cliente;
    }
    public static ArrayList<Ropa> crearListaDeCompras(Local local){

        ArrayList <Ropa> prendasSeleccionadas= new ArrayList<>();

        int op = 0;
        System.out.println("------Inicio Lista de Compras------\n");
        while(op==0){

        local.ObtenerRopaDelArchivo();

        System.out.println(local.mostrarStockRopa());

        System.out.println("Seleccione el indice de la Prenda que desea:");

        int index= scanner.nextInt();

        if (index >= 0 && index < local.getStockRopa().size()) {
            Ropa seleccionada = local.getStockRopa().get(index);
                if (seleccionada.getStock() > 0) {
                    prendasSeleccionadas.add(seleccionada);
                    seleccionada.bajarUnStock();
                }
        }
        System.out.print("¿Desea seleccionar otra prenda? Pulse 0 si asi lo desea : ");
        op=scanner.nextInt();
        }

        return prendasSeleccionadas;
    }
}



