package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.ufps.entities.Resultado;

@Repository
public interface ResultadoRespository extends JpaRepository<Resultado,Integer>{

}