package Model;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;
    private int telefono;
    private String peticion;
    private String direccion;
    private int pago;
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String contraseña, String correo, int telefono, String peticion, String direccion, int pago) {

        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña= contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.peticion = peticion;
        this.direccion = direccion;
        this.pago = pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

}
