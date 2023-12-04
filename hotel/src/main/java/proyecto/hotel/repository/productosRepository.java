package proyecto.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import proyecto.hotel.model.productos;

public interface productosRepository extends MongoRepository<productos, String>  {


    
}
