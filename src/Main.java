import Modelo.Humanos.Cliente;
import Modelo.Finanzas.Compra;
import Modelo.Humanos.Empleado;
import Modelo.Local;
import Modelo.Mercaderia.Ropa;
import Modelo.Mercaderia.Talle;

import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        menu();
}
    public static void menu(){

    boolean salir=false;

    while(!salir) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.println("\n- Menú Principal: \n");
        System.out.println("[1] Gestionar Local\n");
        System.out.println("[2] Realizar Compra\n");
        System.out.println("[3] Salir\n");
        System.out.print("Ingrese su opción: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                subMenuGestionDelLocal();
                break;
            case 2:

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
    public static void subMenuGestionDelLocal (){
        boolean salir=false;

        while(!salir){
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n-- Gestion del Local: \n");
            System.out.println("[1] Gestionar la informacion del Local\n");
            System.out.println("[2] Gestionar Empleados\n");
            System.out.println("[3] Ver el Registro de Clientes del Local\n");
            System.out.println("[4] Gestionar el Stock de Ropa\n");
            System.out.println("[5] Volver al Menu Principal\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();

            switch (opcion){
            case 1:
                subMenuInformacionDelLocal();
                break;
            case 2:
                subMenuGestionEmpleados();
                break;
            case 3:

                break;
            case 4:

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
    public static void subMenuInformacionDelLocal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---------------------------------------------------\n");
            System.out.println("\n--- Informacion del Local: \n");
            System.out.println("[1] Ingresar la Informacion del Local\n");
            System.out.println("[2] Ver la informacion del Local\n");
            System.out.println("[3] Editar la informacion del Local\n");
            System.out.println("[4] Volver al Menu de Gestion del Local\n");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
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
                                System.out.println("Ejemplo1");
                                break;
                            case 2:
                                System.out.println("Ejemplo2");
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
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpcion no valida. Por favor,Ingrese de nuevo la opcion que desea\n");
                    System.out.println("\n\n\n\n");
                    break;
            }
        }
    }
    public static void subMenuGestionEmpleados(){
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

            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    ////MOSTRAMOS LOS EMPLEADOS
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
                        switch (opcionAux) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

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

                    break;
                case 5:

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
    } //Cargar una sola prenda
    public static void cargarRopa(Local localAux){
        int op = 0;
        while(op==0){
            localAux.agregarRopaAlStock(agregarRopa());
            System.out.println("Desea agregar otra prenda?\n(Escribi 0 si queres)");
            op=scanner.nextInt();
        }
    }//Cargar un local de prendas
    public static void mostrarRopa(ArrayList<Ropa> ropaAux){
        if(ropaAux.isEmpty()){
            System.out.println("No hay ropa");
        }else{
            System.out.println("Lista de ropa:");
            for (Ropa ro: ropaAux){
                System.out.println(ro);
            }
        }
    }//Mostrar la ropa
    public static void guardarRopaEnArchivoBinario(ArrayList<Ropa> ropaAux, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(ropaAux);
            System.out.println("Ropa guardada en el archivo binario " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo binario: " + e.getMessage());
        }
    }
    public static void mostrarRopaDesdeArchivoBinario(String nombreArchivo) {
        ArrayList<Ropa> ropaAux = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ropaAux = (ArrayList<Ropa>) ois.readObject();
            System.out.println("Ropa cargada desde el archivo binario " + nombreArchivo + ":");
            mostrarRopa(ropaAux);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer del archivo binario: " + e.getMessage());
        }
    }

    public static Empleado agregarEmpleado(){

        System.out.println("Dime el apellido");
        String apellido = scanner.nextLine();

        System.out.println("Dime el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime el dni");
        String dni = scanner.nextLine();

        System.out.println("Dime la disponibilidad: ");
        boolean disponible = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Dime el horario: ");
        String horario = scanner.nextLine();

        System.out.println("Dime el salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Empleado emp = new Empleado(nombre, apellido, dni, salario, horario);

        return emp;
    }

    public static Cliente agregarCliente(){

        System.out.println("Dime el apellido");
        String apellido = scanner.nextLine();

        System.out.println("Dime el nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime el dni");
        String dni = scanner.nextLine();

        System.out.println("Dime el historial de compra: ");
        double historial = scanner.nextDouble();
        scanner.nextLine();

        Cliente cliente = new Cliente (nombre, apellido, dni, historial);

        return cliente;
    }

    public static Local cargarLocal(){

        System.out.println("Decime la calle del local: ");
        String direccion = scanner.nextLine();

        System.out.println("Decime la altura: ");
        int altura = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Decime el horario de atencion: ");
        String horario = scanner.nextLine();

        Local local = new Local(direccion, altura, horario);

        return local;
    }

    /////////////////////////////////////////cargarCompra y comprobante sujetas a cambios////////////////////////////////////////

    public static Compra cargarCompra(Local local){

        Iterator<Empleado> it = local.getEmpleados().iterator();
        Empleado empleado = null;
        if (it.hasNext()) {
            empleado = it.next();
        } else {
            // x si no hay empleados en el local
            throw new IllegalStateException("No hay empleados disponibles en el local.");
        }
        Compra compra= new Compra(local.getStockRopa(), empleado);

        return compra;
    }

    public static void comprobante(Local local, Compra compra)
    {
        Iterator<Cliente> it = local.getClientes().iterator();
        Cliente cliente = null;
        if (it.hasNext()) {
            cliente = it.next();
        } else {
            // x si no hay Cliente en el local
            throw new IllegalStateException("No hay clientes disponibles en el local.");
        }

        compra.crearPDF(local, cliente);

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}


