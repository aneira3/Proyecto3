package proyecto.hotel.model;
import lombok.ToString;

@ToString
public class Cliente {

    private String numero_documento;

    private String nombre;

    private String correo;

    private String tipo_documento;

    public Cliente(String numero_documento, String nombre, String correo, String tipo_documento) {
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo_documento = tipo_documento;
    }

    public Cliente(){;}

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    
    

    
}
