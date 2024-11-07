package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Continente;
import co.edu.ufps.repositories.ContinenteRespository;
import co.edu.ufps.repositories.SeleccionRespository;
@Service
public class ContinenteService {

	@Autowired
	ContinenteRespository continenteRepository;
	
	@Autowired
	public SeleccionRespository seleccionRepository;

	
	public List<Continente> list() {
		return continenteRepository.findAll();
	}
	
	public Continente create(Continente continente) {
		return continenteRepository.save(continente);
	}

	// Obtener un continente por ID
	public Optional<Continente> getById(Integer id) {
		return continenteRepository.findById(id);
	}

	// Actualizar un continente existente
	public Optional<Continente> update(Integer id, Continente continenteDetails) {
		Optional<Continente> optionalcontinente = continenteRepository.findById(id);
		if (!optionalcontinente.isPresent()) {
			return Optional.empty();
		}

		Continente continente = optionalcontinente.get();

		// Actualiza otros campos según sea necesario
		continente.setNombre(continenteDetails.getNombre());

		return Optional.of(continenteRepository.save(continente));
	}

	// Eliminar un continente por ID
	public boolean delete(Integer id) {
		if (!continenteRepository.existsById(id)) {
			return false;
		}
		continenteRepository.deleteById(id);
		return true;
	}
}
