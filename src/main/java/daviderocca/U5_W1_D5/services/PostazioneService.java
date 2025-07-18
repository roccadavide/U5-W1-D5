package daviderocca.U5_W1_D5.services;

import daviderocca.U5_W1_D5.entities.Edificio;
import daviderocca.U5_W1_D5.entities.Postazione;
import daviderocca.U5_W1_D5.enums.TipoPostazione;
import daviderocca.U5_W1_D5.repositories.EdificioRepository;
import daviderocca.U5_W1_D5.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    public Postazione savePostazione (String descrizione, TipoPostazione tipoPostazione, int numeroMassimoPersone, Long edificioId) {

        Edificio edificio = edificioRepository.findById(edificioId).orElseThrow(() -> new RuntimeException("Edificio non trovato o inesistente, controlla ed inserisci un altro id!"));

        Postazione newPostazione = new Postazione(descrizione, tipoPostazione, numeroMassimoPersone, edificio);

        postazioneRepository.save(newPostazione);

        log.info("La postazione " + newPostazione.getId() + " è stata correttamente salvata nel DB!");

        return newPostazione;
    }

    //questo è un metodo per trovare le postazioni cercando in base al tipo e alla citta come da consegna
    public List<Postazione> cercaPerTipoECittà(TipoPostazione tipo, String città) {
        return postazioneRepository.findByTipoPostazioneAndEdificio_Città(tipo, città);
    }

}
