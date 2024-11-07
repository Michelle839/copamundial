package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.ufps.entities.Continente;

@Repository
public interface ContinenteRespository extends JpaRepository<Continente,Integer>{

}
