package proyecto.hotel;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import proyecto.hotel.model.habitaciones;
import proyecto.hotel.model.productos;
import proyecto.hotel.model.reservaHabitacion;
import proyecto.hotel.model.reservaServicio;
import proyecto.hotel.model.serviciosReservables;
import proyecto.hotel.repository.habitacionesRepository;
import proyecto.hotel.repository.productosRepository;
import proyecto.hotel.repository.reservaHabitacionRepository;
import proyecto.hotel.repository.reservaServicioRepository;
import proyecto.hotel.repository.serviciosReservablesRepository;
import proyecto.hotel.repository.habitacionesRepository.req2;
import proyecto.hotel.repository.reservaServicioRepository.req1;
import proyecto.hotel.repository.reservaServicioRepository.respuesta;

@SpringBootApplication
public class HotelApplication implements CommandLineRunner {

	@Autowired
	private habitacionesRepository habRepo;
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception{
		
	}
}
