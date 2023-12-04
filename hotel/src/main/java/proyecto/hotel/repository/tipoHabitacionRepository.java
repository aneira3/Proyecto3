package proyecto.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import proyecto.hotel.model.tipoHabitacion;


public interface tipoHabitacionRepository extends MongoRepository<tipoHabitacion, String>  {

    @Query("{tipo: ?0}")
    List<tipoHabitacion> findByTipo(String tipo);

}
