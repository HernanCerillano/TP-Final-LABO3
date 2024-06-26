package Modelo.Datos;
import javax.swing.*;
import java.io.*;

public class Archivo<T> {

    public T leerArchivo(File file) {
        T data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            data = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error en la lectura del archivo: " + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Los datos son del archivo: " + file.getName());
        return data;
    }

    public void escribirArchivo(File file, T data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(data);
            JOptionPane.showMessageDialog(null, "Los datos escritos estan en el archivo: " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Error escribibiendo en el archivo: " + e.getMessage());
        }
    }

    public void crearArchivo(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo creado: " + fileName);
            } else {
                throw new RuntimeException("El archivo ya existia: " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creando el archivo: " + e.getMessage());
        }
    }

    public void borrarArchivo(File file) {
        if (file.delete()) {
            JOptionPane.showMessageDialog(null, "El archivo borrado es: " + file.getName());
        } else {
            throw new RuntimeException("Error borrando el archivo: " + file.getName());
        }
    }

    public void renombrarAchivo(File file, String newName) {
        File newFile = new File(file.getParent(), newName);
        if (file.renameTo(newFile)) {
            JOptionPane.showMessageDialog(null, "Archivo renombrado como: " + newName);
        } else {
            throw new RuntimeException("Error renombrando al archivo: " + file.getName());
        }
    }

    public void copiarArchivo(File sourceFile, File destFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            JOptionPane.showMessageDialog(null, "Archivo copiado: " + sourceFile.getName() + " en " + destFile.getName());
        } catch (IOException e) {
            throw new RuntimeException("Error copiando el archivo: " + e.getMessage());
        }
    }
}