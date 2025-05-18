package Controller;

import Model.Usuario;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public abstract class UsuarioController {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void guardarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            String linea = usuario.getNombre() + ","
                    + usuario.getUsuario() + ","
                    + usuario.getContraseña() + ","
                    + usuario.getCorreo() + ","
                    + usuario.getTelefono() + ","
                    + usuario.getPeticion() + ","
                    + usuario.getDireccion() + ","
                    + usuario.getPago();
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
        }
    }

    protected abstract void reporte();

    public static void cargarUsuarios() {
        File archivo = new File("usuarios.txt");
        if (!archivo.exists()) {
            usuarios.clear();
            usuarios.add(new Usuario("Jaime Andres Chang Moreno", "Chang10", "fuertecomoelroble", "Jchangm@gmail.com", 1234, "", "olaya", 10));
            actualizarArchivo();
            return;
        }

        usuarios.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    String nombre = partes[0];
                    String usuario = partes[1];
                    String contraseña = partes[2];
                    String correo = partes[3];

                    int telefono = 0;
                    try {
                        telefono = Integer.parseInt(partes[4]);
                    } catch (NumberFormatException e) {
                        System.out.println("Teléfono inválido para usuario: " + usuario + " valor: " + partes[4]);
                    }

                    int pago = 0;
                    try {
                        pago = Integer.parseInt(partes[7]);
                    } catch (NumberFormatException e) {
                        System.out.println("Pago inválido para usuario: " + usuario + " valor: " + partes[5]);
                    }

                    String direccion = partes[6];
                    String peticion = partes[5];
                    usuarios.add(new Usuario(nombre, usuario, contraseña, correo, telefono, peticion, direccion, pago));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
    }

    public static boolean validarUsuario(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                if (u.getContraseña().equals(contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de Sesión Exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario ingresado no existe. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public static boolean RegistroUsuario(String nombre, String usuario, String contraseña, String correo, String telefono, String direccion, String pago) {
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido");
            return false;
        }
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no válido");
            return false;
        }
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida");
            return false;
        }
        int telefonoInt = 0;
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "numero no válida");
            return false;
        } else {
            try {
                telefonoInt = Integer.parseInt(telefono);
                if (telefonoInt <= 0) {
                    JOptionPane.showMessageDialog(null, "Telefono Invalido");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Telefono debe ser un número entero ");
                return false;
            }
        }
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "");
            return false;
        }
        int pagoInt = 0;
        if (pago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pago no válido");
            return false;
        } else {
            try {
                pagoInt = Integer.parseInt(pago);
                if (pagoInt <= 0) {
                    JOptionPane.showMessageDialog(null, "Pago Invalido");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Pago debe ser un número entero");
                return false;
            }

            correo = correo.trim();
            if (correo.isEmpty() || !(correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com") || correo.endsWith("@outlook.com"))) {
                JOptionPane.showMessageDialog(null, "Correo no válido. Solo aceptamos Gmail, Hotmail y Outlook.");
                return false;
            }

            for (Usuario u : usuarios) {
                if (u.getUsuario().equals(usuario)) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso");
                    return false;
                }
            }

            Usuario nuevoUsuario = new Usuario(nombre, usuario, contraseña, correo, telefonoInt, "", direccion, 0);
            usuarios.add(nuevoUsuario);
            guardarUsuario(nuevoUsuario);

            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Softwart EASYSOFT", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }

    public static void eliminarUsuario(String usuario) {
        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)) {
                usuarios.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        } else {
            actualizarArchivo();
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
        }
    }

    public static void modificarUsuario(String nombre, String username, String contraseña, String correo, int telefono, String direccion, String pago) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getUsuario().equals(username)) {
                usuario.setNombre(nombre);
                usuario.setContraseña(contraseña);
                usuario.setCorreo(correo);
                usuario.setTelefono(telefono);
                usuario.setDireccion(direccion);
                usuario.setPago(Integer.parseInt(pago));
                actualizarArchivo();
                JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
    }

    private static void actualizarArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            for (Usuario usuario : usuarios) {
                String linea = usuario.getNombre() + ","
                        + usuario.getUsuario() + ","
                        + usuario.getContraseña() + ","
                        + usuario.getCorreo() + ","
                        + usuario.getTelefono() + ","
                        + usuario.getPeticion() + ","
                        + usuario.getDireccion() + ","
                        + usuario.getPago();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static ArrayList<String[]> mostrarPersonasTabla() {
        ArrayList<String[]> filas = new ArrayList<>();
        File archivo = new File("usuarios.txt");
        if (!archivo.exists()) {
            return filas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    filas.add(partes);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return filas;
    }

    public void limpiarTabla(DefaultTableModel modelo) {
        // Elimina todas las filas del modelo de la tabla
        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
