package daviderocca.U5_W1_D5.services;

import daviderocca.U5_W1_D5.entities.Postazione;
import daviderocca.U5_W1_D5.entities.Prenotazione;
import daviderocca.U5_W1_D5.entities.Utente;
import daviderocca.U5_W1_D5.repositories.PostazioneRepository;
import daviderocca.U5_W1_D5.repositories.PrenotazioneRepository;
import daviderocca.U5_W1_D5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePrenotazione(LocalDate dataPrenotazione, String usernameUtente, Long postazioneId) {


        //questo è un controllo sull' esistenza del utente nel db, se non esiste non può fare la prenotazione e si lancia un exception
        Utente utente = utenteRepository.findById(usernameUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato o inesistente, controlla ed inserisci un altro username!"));

        //qua stessa cosa per la postazione
        Postazione postazione = postazioneRepository.findById(postazioneId)
                .orElseThrow(() -> new RuntimeException("Postazione non trovata o inesistente, controlla ed inserisci un altro ID!"));

        //questo è un controllo per vedere se la data inserita sia non prima di oggi
        if (dataPrenotazione.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data di prenotazione non può essere nel passato: " + dataPrenotazione);
        }

        //questo invece controlla che dato un username e data se esiste nel DB una prenotazione con lo stesso username e data
        boolean piuPrenotazioniStessaData = prenotazioneRepository.existsByUtente_UsernameAndDataPrenotazione(usernameUtente, dataPrenotazione);

        //se è vero che esiste lancio un exception
        if(piuPrenotazioniStessaData) throw new RuntimeException(utente.getNome() + ", hai già una prenotazione attiva in data: " + dataPrenotazione);

        //stessa cosa per la postazione e la data per verificare che non sia già prenotato
        boolean liberaOccupata = prenotazioneRepository.existsByPostazioneIdAndDataPrenotazione(postazioneId, dataPrenotazione);

    if(liberaOccupata) throw new RuntimeException(utente.getNome() + ", la postazione è gia stata prenotata in data: " + dataPrenotazione + " ||Prova un altra data!");


        Prenotazione newPrenotazione = new Prenotazione(dataPrenotazione, utente, postazione);

        prenotazioneRepository.save(newPrenotazione);

        log.info("La prenotazione " + newPrenotazione.getId() + " è stata correttamente salvata nel DB!");

    }

}
