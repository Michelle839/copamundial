package co.edu.ufps.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.repositories.SeleccionRespository;
@Service
public class SeleccionService {

	@Autowired
	SeleccionRespository seleccionRespository;
	
	@Autowired
	public SeleccionRespository seleccionRepository;

	
	public List<Seleccion> list() {
		return seleccionRepository.findAll();
	}
	
	public List<Resultado> listResultados(Integer id) {
		Optional<Seleccion> rolOpt = seleccionRepository.findById(id);
		return rolOpt.map(Seleccion::getResultados).orElse(Collections.emptyList());
	}
	
	public Seleccion create(Seleccion seleccion) {
		return seleccionRepository.save(seleccion);
	}

	// Obtener un seleccion por ID
	public Optional<Seleccion> getById(Integer id) {
		return seleccionRepository.findById(id);
	}
	
	//Obtener selecciones por grupo
	public List<Seleccion> listSeleccionesGrupo(String grupo) {
		return seleccionRepository.findByGrupo(grupo);
	}
	
	
	

	// Actualizar un seleccion existente
	public Optional<Seleccion> update(Integer id, Seleccion seleccionDetails) {
		Optional<Seleccion> optionalseleccion = seleccionRepository.findById(id);
		if (!optionalseleccion.isPresent()) {
			return Optional.empty();
		}

		Seleccion seleccion = optionalseleccion.get();

		// Actualiza otros campos según sea necesario
		seleccion.setNombre(seleccionDetails.getNombre());
		seleccion.setGrupo(seleccionDetails.getGrupo());
		
		//Actualizar tambien con continente
		seleccion.setContinente(seleccionDetails.getContinente());

		return Optional.of(seleccionRepository.save(seleccion));
	}

	// Eliminar un seleccion por ID
	public boolean delete(Integer id) {
		if (!seleccionRepository.existsById(id)) {
			return false;
		}
		seleccionRepository.deleteById(id);
		return true;
	}
}
