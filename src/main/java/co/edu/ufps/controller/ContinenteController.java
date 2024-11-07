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

import co.edu.ufps.entities.Continente;
import co.edu.ufps.services.ContinenteService;

@RestController
@RequestMapping("/continentes")
public class ContinenteController {
	@Autowired
	private ContinenteService continenteService;

	@GetMapping
	public List<Continente>  list() {
		
		return continenteService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Continente> getById(@PathVariable Integer id) {
		Optional<Continente> Continente = continenteService.getById(id);
		return Continente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Continente create(@RequestBody Continente Continente) {
		return continenteService.create(Continente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Continente> update(@PathVariable Integer id, @RequestBody Continente ContinenteDetails) {
		Optional<Continente> updatedContinente = continenteService.update(id, ContinenteDetails);
		return updatedContinente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		boolean deleted = continenteService.delete(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	

}
