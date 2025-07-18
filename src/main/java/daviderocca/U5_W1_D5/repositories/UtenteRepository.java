package daviderocca.U5_W1_D5.repositories;

import daviderocca.U5_W1_D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
