package proyecto.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import proyecto.hotel.model.serviciosReservables;


public interface serviciosReservablesRepository extends MongoRepository<serviciosReservables, String> {
    
    
    @Query("{tipo: ?0}")
    List<serviciosReservables> findByTipo(String tipo);


    
    
    
}
