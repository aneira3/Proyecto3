package proyecto.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="servicios_reservables")
@ToString
public class serviciosReservables {
    @Id
    private String _id;
    private String tipo;
    private float costo_por_horas;
    private int capacidad;
    public serviciosReservables(String _id, String tipo, float costo_por_horas, int capacidad) {
        super();
        this._id = _id;
        this.tipo = tipo;
        this.costo_por_horas = costo_por_horas;
        this.capacidad = capacidad;
    }
    public serviciosReservables(){;}

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
    public float getCosto_por_horas() {
        return costo_por_horas;
    }
    public void setCosto_por_horas(float costo_por_horas) {
        this.costo_por_horas = costo_por_horas;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    
    
}
