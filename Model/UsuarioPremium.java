package Model;

public class UsuarioPremium extends Usuario{
    private String beneficios;

    public UsuarioPremium() {
        super();
    }

    public UsuarioPremium( String nombre, String usuario,String contraseña, String correo, int telefono, String peticion, String direccion, int pago, String beneficios) {
        super(nombre, usuario,contraseña, correo, telefono, peticion, direccion, pago);
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    
    public double calcularPagoConDescuento() {
        return getPago() * 0.8; 
    }
}


