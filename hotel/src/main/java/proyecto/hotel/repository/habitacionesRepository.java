package proyecto.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import lombok.ToString;
import proyecto.hotel.model.habitaciones;

public interface habitacionesRepository extends MongoRepository<habitaciones, String> {

    @Query("{numero_habitacion: ?0}")
    List<habitaciones> findByNumero(int numero);

    @ToString
    public class req2
    {
        private int _id;
        private float porcentajeOcupacion;
        public int get_id() {
            return _id;
        }
        public void set_id(int _id) {
            this._id = _id;
        }
        public float getPorcentajeOcupacion() {
            return porcentajeOcupacion;
        }
        public void setPorcentajeOcupacion(float porcentajeOcupacion) {
            this.porcentajeOcupacion = porcentajeOcupacion;
        }
        
    }

    @Aggregation(pipeline={"{$match: {fechaEntrada: { $gte: ISODate('2022-12-02T00:00:00.000Z')},fechaSalida: { $lte: ISODate('2023-12-01T23:59:59.999Z') }}}", "{$project: {numero_habitacion: 1, diasOcupada: { $subtract: ['$fechaSalida', '$fechaEntrada'] }}}"
    ,"{$group: {_id: '$numero_habitacion', totalDiasOcupados: { $sum: '$diasOcupada' } }}",    
    "{$project: {porcentajeOcupacion: {$multiply: [{ $divide: ['$totalDiasOcupados', (365 * 24 * 60 * 60 * 1000)] }, 100]}}}" })
    List<req2> getRequerimiento2();

    
    @Aggregation(pipeline = {
        "{ $match: { fechaEntrada: { $gte: new Date('2022-12-02T00:00:00.000Z'), fechaSalida: { $lte: new Date('2023-12-01T23:59:59.999Z') } } } }",
        "{ $project: { numero_habitacion: 1, diasOcupada: { $subtract: ['$fechaSalida', '$fechaEntrada'] } } }",
        "{ $group: { _id: '$numero_habitacion', totalDiasOcupados: { $sum: '$diasOcupada' } } }",
        "{ $project: { porcentajeOcupacion: { $multiply: [{ $divide: ['$totalDiasOcupados', { $multiply: [365, 24, 60, 60, 1000] }] }, 100] } } }"
    })
    List<req2> getrequerimiento2();
    
    
 
}
