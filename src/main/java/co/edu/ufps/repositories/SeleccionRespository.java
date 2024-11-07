package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entities.Seleccion;


@Repository
public interface SeleccionRespository extends JpaRepository<Seleccion,Integer>{

}
