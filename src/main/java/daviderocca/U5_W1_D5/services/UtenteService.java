package daviderocca.U5_W1_D5.services;


import daviderocca.U5_W1_D5.entities.Utente;
import daviderocca.U5_W1_D5.exceptions.ValidationException;
import daviderocca.U5_W1_D5.repositories.PostazioneRepository;
import daviderocca.U5_W1_D5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente saveUser(String username, String nome, String cognome, String email) {

        if(utenteRepository.existsByUsername(username)) throw new ValidationException("Username " + username + " già in uso, inseriscine un altro!");

        if(utenteRepository.existsByEmail(email)) throw new ValidationException("Email " + email + " già in uso, inseriscine un altra!");

        if (nome.length() < 2) throw new ValidationException("Il nome non può essere più corto di 2 caratteri!");

        Utente newUtente = new Utente(username, nome, cognome, email);

        utenteRepository.save(newUtente);

        log.info("L'utente con email" + newUtente.getEmail() + " è stato correttamente salvato nel DB!");

        return newUtente;

    }

}
