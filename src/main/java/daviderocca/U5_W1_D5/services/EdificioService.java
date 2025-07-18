package daviderocca.U5_W1_D5.services;

import daviderocca.U5_W1_D5.entities.Edificio;
import daviderocca.U5_W1_D5.exceptions.ValidationException;
import daviderocca.U5_W1_D5.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio saveEdificio(String nomeEdificio, String indirizzo, String città) {

        if(edificioRepository.existsByNomeEdificio(nomeEdificio)) throw new ValidationException("Il nome " + nomeEdificio + " è già in uso, inseriscine un altro!");

        if (nomeEdificio.length() < 2) throw new ValidationException("Il nome deell'edificio non può essere più corto di 2 caratteri!");

        Edificio newEdificio = new Edificio(nomeEdificio, indirizzo, città);

        edificioRepository.save(newEdificio);

        log.info("L' edificio " + newEdificio.getNomeEdificio() + " è stato correttamente salvato nel DB!");

        return newEdificio;

    }

}
