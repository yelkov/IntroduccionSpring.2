package edu.badpals.contador_votos.model.repository;

import edu.badpals.contador_votos.model.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
