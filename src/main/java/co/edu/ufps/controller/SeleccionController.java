package co.edu.ufps.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.services.SeleccionService;

@RestController
@RequestMapping("/seleccions")
public class SeleccionController {
	@Autowired
	private SeleccionService seleccionService;

	@GetMapping
	public List<Seleccion>  list() {
		
		return seleccionService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seleccion> getById(@PathVariable Integer id) {
		Optional<Seleccion> Seleccion = seleccionService.getById(id);
		return Seleccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{id}/resultados") // Podrías usar una ruta más descriptiva
	public ResponseEntity<List<Resultado>> listResultados(@PathVariable Integer id) {
		List<Resultado> resultados = seleccionService.listResultados(id);
		if (resultados.isEmpty()) {
			return ResponseEntity.notFound().build(); // Retorna un 404 si no hay resultados para ese rol
		}
		return ResponseEntity.ok(resultados); // Retorna un 200 con la lista de resultados
	}
	
	@GetMapping("/grupo/{grupo}")
	public ResponseEntity<List<Seleccion>>getByGrupo(@PathVariable String grupo) {
		List<Seleccion> selecciones = seleccionService.listSeleccionesGrupo(grupo);
		if (selecciones.isEmpty()) {
			return ResponseEntity.notFound().build(); // Retorna un 404 si no hay resultados para ese rol
		}
		return ResponseEntity.ok(selecciones); // Retorna un 200 con la lista de resultados
	}
	
	@PostMapping
	public Seleccion create(@RequestBody Seleccion Seleccion) {
		return seleccionService.create(Seleccion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Seleccion> update(@PathVariable Integer id, @RequestBody Seleccion SeleccionDetails) {
		Optional<Seleccion> updatedSeleccion = seleccionService.update(id, SeleccionDetails);
		return updatedSeleccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		boolean deleted = seleccionService.delete(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	

}
