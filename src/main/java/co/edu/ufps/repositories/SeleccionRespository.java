package co.edu.ufps.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.ufps.entities.Seleccion;


@Repository
public interface SeleccionRespository extends JpaRepository<Seleccion,Integer>{
//	Optional<Seleccion> findByGrupo(String grupo);
	List<Seleccion> findByGrupo(String grupo);
}
