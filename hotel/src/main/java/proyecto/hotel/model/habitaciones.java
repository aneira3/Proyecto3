package proyecto.hotel.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="habitaciones")
@ToString
public class habitaciones {
    @Id
    private String _id;
    private int numero_habitacion;
    private float costo;
    private String tipo;
    private int capacidad;

    public habitaciones(String _id, int numero_habitacion, float costo, String tipo, int capacidad) {
        super();
        this._id = _id;
        this.numero_habitacion = numero_habitacion;
        this.costo = costo;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }
    public habitaciones(){;}

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    

    
    
}
