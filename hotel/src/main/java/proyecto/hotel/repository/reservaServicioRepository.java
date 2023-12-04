package proyecto.hotel.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import lombok.ToString;
import proyecto.hotel.model.Cliente;
import proyecto.hotel.model.reservaServicio;
import proyecto.hotel.model.serviciosReservables;


public interface reservaServicioRepository extends MongoRepository<reservaServicio, String> {


  
    @ToString
    public class respuesta
    {
        
    @Id
    private String _id;
    private LocalDate fecha;
    private float costo;
    private int numero_habitacion;
    private String servicio_reservable;
    private Cliente cliente;
    private int duracion;
    @DBRef
    List<serviciosReservables> servicios;
    public respuesta(String _id, LocalDate fecha, float costo, int numero_habitacion, String servicio_reservable,
            Cliente cliente, int duracion, List<serviciosReservables> servicio) {
        this._id = _id;
        this.fecha = fecha;
        this.costo = costo;
        this.numero_habitacion = numero_habitacion;
        this.servicio_reservable = servicio_reservable;
        this.cliente = cliente;
        this.duracion = duracion;
        this.servicios = servicio;
    }
    public respuesta(){;}

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
    public String getServicio_reservable() {
        return servicio_reservable;
    }
    public void setServicio_reservable(String servicio_reservable) {
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
    public List<serviciosReservables> getServicio() {
        return servicios;
    }
    public void setServicio(List<serviciosReservables> servicio) {
        this.servicios = servicio;
    }
    
    
    }

    @ToString
    public class req1
    {
        private int _id;
        private double totalCantidades;
        public int get_id() {
            return _id;
        }
        public void set_id(int _id) {
            this._id = _id;
        }
        public double getTotalCantidades() {
            return totalCantidades;
        }
        public void setTotalCantidades(double totalCantidades) {
            this.totalCantidades = totalCantidades;
        }
        
        
    }

    @Aggregation(pipeline={"{ $lookup: { from: servicios_reservables, localField: servicio_reservable, foreignField: _id, as: servicios } }"})
    List<respuesta> darReservas();


    @Aggregation(pipeline={"{ $lookup: { from: servicios_reservables, localField: servicio_reservable, foreignField: _id, as: servicios } }","{$match:{'cliente.nombre':?0 }}" })
    List<respuesta> findByNombre(String nombre);

    @Aggregation(pipeline={"{$match:{fecha: { $gte: { '$date': ?0 },  $lte: { '$date': ?1 }}}}", "{ $group: { _id: '$numero_habitacion', totalCantidades: { $sum: '$costo' }  }}"})
    List<req1> getRequerimiento1(String fecha1, String fecha2);


    @Query("{cliente.numero_documento: ?0, fecha: {$gte: { '$date': ?1 }, $lte: { '$date': ?2 } } }")
    List<reservaServicio> getRequerimiento3(String numero, String fecha1, String fecha2);

    @Aggregation(pipeline={"{ $lookup: { from: servicios_reservables, localField: servicio_reservable, foreignField: _id, as: servicios } }","{$match:{'cliente.nombre':?0, fecha: {$gte: { '$date': ?1 }, $lte: { '$date': ?2 } }}}" })
    List<respuesta> req3(String nombre, String fecha1, String fecha2);

  


   

}

