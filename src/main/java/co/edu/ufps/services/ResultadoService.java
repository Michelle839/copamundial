package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.repositories.ResultadoRespository;
import co.edu.ufps.repositories.SeleccionRespository;
@Service
public class ResultadoService {

	@Autowired
	ResultadoRespository resultadoRepository;
	
	@Autowired
	public SeleccionRespository seleccionRepository;

	
	public List<Resultado> list() {
		return resultadoRepository.findAll();
	}
	
	public Resultado create(Resultado resultado) {
		return resultadoRepository.save(resultado);
	}

	// Obtener un resultado por ID
	public Optional<Resultado> getById(Integer id) {
		return resultadoRepository.findById(id);
	}

	// Actualizar un resultado existente
	public Optional<Resultado> update(Integer id, Resultado resultadoDetails) {
		Optional<Resultado> optionalresultado = resultadoRepository.findById(id);
		if (!optionalresultado.isPresent()) {
			return Optional.empty();
		}

		Resultado resultado = optionalresultado.get();

		// Actualiza otros campos según sea necesario
		resultado.setGoles(resultadoDetails.getGoles());
		resultado.setAmarillas(resultadoDetails.getAmarillas());
		resultado.setRojas(resultadoDetails.getRojas());
		return Optional.of(resultadoRepository.save(resultado));
	}

	// Eliminar un resultado por ID
	public boolean delete(Integer id) {
		if (!resultadoRepository.existsById(id)) {
			return false;
		}
		resultadoRepository.deleteById(id);
		return true;
	}
}
