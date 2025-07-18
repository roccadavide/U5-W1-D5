package daviderocca.U5_W1_D5.repositories;

import daviderocca.U5_W1_D5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    boolean existsByNomeEdificio(String nomeEdificio);

}
