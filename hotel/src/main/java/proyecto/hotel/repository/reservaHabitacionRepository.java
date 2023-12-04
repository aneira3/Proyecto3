package proyecto.hotel.repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto.hotel.model.reservaHabitacion;



public interface reservaHabitacionRepository extends MongoRepository<reservaHabitacion, String> {

    @Query("{'cliente.nombre': ?0}")
    List<reservaHabitacion> findByNombre(String nombre);


    @Query("{ 'fechaEntrada' : { $eq : { '$date': ?0 } } }")
    List<reservaHabitacion> buscarPorFecha(String fechaEntrada);

    List<reservaHabitacion> findByFechaSalida(LocalDate fechaSalida);
}
