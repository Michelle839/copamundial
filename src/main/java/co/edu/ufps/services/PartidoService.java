package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Partido;
import co.edu.ufps.repositories.PartidoRespository;
import co.edu.ufps.repositories.SeleccionRespository;
@Service
public class PartidoService {

	@Autowired
	PartidoRespository partidoRepository;
	
	@Autowired
	public SeleccionRespository seleccionRepository;

	
	public List<Partido> list() {
		return partidoRepository.findAll();
	}
	
	public Partido create(Partido partido) {
		return partidoRepository.save(partido);
	}

	// Obtener un partido por ID
	public Optional<Partido> getById(Integer id) {
		return partidoRepository.findById(id);
	}

	// Actualizar un partido existente
	public Optional<Partido> update(Integer id, Partido partidoDetails) {
		Optional<Partido> optionalpartido = partidoRepository.findById(id);
		if (!optionalpartido.isPresent()) {
			return Optional.empty();
		}

		Partido partido = optionalpartido.get();

		// Actualiza otros campos según sea necesario
		partido.setFecha(partidoDetails.getFecha());

		return Optional.of(partidoRepository.save(partido));
	}

	// Eliminar un partido por ID
	public boolean delete(Integer id) {
		if (!partidoRepository.existsById(id)) {
			return false;
		}
		partidoRepository.deleteById(id);
		return true;
	}
}
