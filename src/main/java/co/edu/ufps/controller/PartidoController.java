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

import co.edu.ufps.entities.Partido;
import co.edu.ufps.services.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
	@Autowired
	private PartidoService partidoService;

	@GetMapping
	public List<Partido>  list() {
		
		return partidoService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Partido> getById(@PathVariable Integer id) {
		Optional<Partido> Partido = partidoService.getById(id);
		return Partido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Partido create(@RequestBody Partido Partido) {
		return partidoService.create(Partido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Partido> update(@PathVariable Integer id, @RequestBody Partido PartidoDetails) {
		Optional<Partido> updatedPartido = partidoService.update(id, PartidoDetails);
		return updatedPartido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		boolean deleted = partidoService.delete(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	

}
