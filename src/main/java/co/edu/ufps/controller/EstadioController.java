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

import co.edu.ufps.entities.Estadio;
import co.edu.ufps.services.EstadioService;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
	@Autowired
	private EstadioService estadioService;

	@GetMapping
	public List<Estadio>  list() {
		
		return estadioService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estadio> getById(@PathVariable Integer id) {
		Optional<Estadio> Estadio = estadioService.getById(id);
		return Estadio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Estadio create(@RequestBody Estadio Estadio) {
		return estadioService.create(Estadio);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estadio> update(@PathVariable Integer id, @RequestBody Estadio EstadioDetails) {
		Optional<Estadio> updatedEstadio = estadioService.update(id, EstadioDetails);
		return updatedEstadio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		boolean deleted = estadioService.delete(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	

}
