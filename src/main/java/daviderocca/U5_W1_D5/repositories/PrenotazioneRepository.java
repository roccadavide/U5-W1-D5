package daviderocca.U5_W1_D5.repositories;

import daviderocca.U5_W1_D5.entities.Postazione;
import daviderocca.U5_W1_D5.entities.Prenotazione;
import daviderocca.U5_W1_D5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByPostazioneIdAndDataPrenotazione(Long postazioneId, LocalDate dataPrenotazione);

    boolean existsByUtente_UsernameAndDataPrenotazione(String usernameUtente, LocalDate dataPrenotazione);

}
