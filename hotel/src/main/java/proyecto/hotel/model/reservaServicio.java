package proyecto.hotel.model;

import java.time.LocalDate;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="reserva_servicio")
@ToString
public class reservaServicio {

    @Id
    private String _id;
    private LocalDate fecha;
    private float costo;
    private int numero_habitacion;
    private ObjectId servicio_reservable;
    private Cliente cliente;
    private int duracion;
    public reservaServicio(String _id, LocalDate fecha, float costo, int numero_habitacion, ObjectId servicio_reservable,
            Cliente cliente, int duracion) {
        super();
        this._id = _id;
        this.fecha = fecha;
        this.costo = costo;
        this.numero_habitacion = numero_habitacion;
        this.servicio_reservable = servicio_reservable;
        this.cliente = cliente;
        this.duracion = duracion;
    }


    public reservaServicio(){;}


    
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public int getNumero_habitacion() {
        return numero_habitacion;
    }
    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }
    public ObjectId getServicio_reservable() {
        return servicio_reservable;
    }
    public void setServicio_reservable(ObjectId servicio_reservable) {
        this.servicio_reservable = servicio_reservable;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


  

    
    
 
    
}
