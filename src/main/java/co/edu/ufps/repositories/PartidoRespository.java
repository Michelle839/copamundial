package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.ufps.entities.Partido;

@Repository
public interface PartidoRespository extends JpaRepository<Partido,Integer>{

}
