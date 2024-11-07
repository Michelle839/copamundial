package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Estadio;
import co.edu.ufps.repositories.EstadioRespository;
import co.edu.ufps.repositories.SeleccionRespository;
@Service
public class EstadioService {

	@Autowired
	EstadioRespository estadioRepository;
	
	@Autowired
	public SeleccionRespository seleccionRepository;

	
	public List<Estadio> list() {
		return estadioRepository.findAll();
	}
	
	public Estadio create(Estadio estadio) {
		return estadioRepository.save(estadio);
	}

	// Obtener un estadio por ID
	public Optional<Estadio> getById(Integer id) {
		return estadioRepository.findById(id);
	}

	// Actualizar un estadio existente
	public Optional<Estadio> update(Integer id, Estadio estadioDetails) {
		Optional<Estadio> optionalestadio = estadioRepository.findById(id);
		if (!optionalestadio.isPresent()) {
			return Optional.empty();
		}

		Estadio estadio = optionalestadio.get();

		// Actualiza otros campos según sea necesario
		estadio.setNombre(estadioDetails.getNombre());

		return Optional.of(estadioRepository.save(estadio));
	}

	// Eliminar un estadio por ID
	public boolean delete(Integer id) {
		if (!estadioRepository.existsById(id)) {
			return false;
		}
		estadioRepository.deleteById(id);
		return true;
	}
}
