package proyecto.hotel.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="tipo_habitacion")
@ToString
public class tipoHabitacion {
    
    @Id
    private String _id;
    
    private String tipo;

    private float costo;

    private List amenidades;

    public tipoHabitacion(String _id, String tipo, float costo, List amenidades) {
        super();
        this._id = _id;
        this.tipo = tipo;
        this.costo = costo;
        this.amenidades = amenidades;
    }

    public tipoHabitacion(){;}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public List getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(List amenidades) {
        this.amenidades = amenidades;
    }


    
    

    
}
