package proyecto.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="productos")
@ToString
public class productos {

    @Id
    private String _id;
    
    private String nombre;

    private float costo;

    private String tipo;

    public productos(String _id, String nombre, float costo, String tipo) {
        super();
        this._id = _id;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    

    
}
