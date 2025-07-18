package daviderocca.U5_W1_D5.runners;

import daviderocca.U5_W1_D5.entities.Edificio;
import daviderocca.U5_W1_D5.entities.Postazione;
import daviderocca.U5_W1_D5.entities.Utente;
import daviderocca.U5_W1_D5.enums.TipoPostazione;
import daviderocca.U5_W1_D5.repositories.EdificioRepository;
import daviderocca.U5_W1_D5.repositories.PostazioneRepository;
import daviderocca.U5_W1_D5.repositories.PrenotazioneRepository;
import daviderocca.U5_W1_D5.repositories.UtenteRepository;
import daviderocca.U5_W1_D5.services.EdificioService;
import daviderocca.U5_W1_D5.services.PostazioneService;
import daviderocca.U5_W1_D5.services.PrenotazioneService;
import daviderocca.U5_W1_D5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class GestionePrenotazioni implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {

//        Edificio edificio1 = edificioService.saveEdificio("Palazzo Dante", "Via Roma 4", "Bergamo");
//        Edificio edificio2 = edificioService.saveEdificio("Edificio Corso Como", "Corso Como 110", "Milano");
//        Edificio edificio3 = edificioService.saveEdificio("Palazzo Visconti", "Via Belotti 12", "Bergamo");
//
//        Postazione postazione1Edificio1 = postazioneService.savePostazione("Open space al terzo piano", TipoPostazione.OPENSPACE, 4, edificio1.getId());
//        Postazione postazione2Edificio1 = postazioneService.savePostazione("Spaziosa sala per riunioni", TipoPostazione.SALA_RIUNIONI, 10, edificio1.getId());
//        Postazione postazione3Edificio1 = postazioneService.savePostazione("Postazione privata con due finestre", TipoPostazione.PRIVATO, 2, edificio1.getId());
//
//        Postazione postazione1Edificio2 = postazioneService.savePostazione("Open space con bagno e balcone", TipoPostazione.OPENSPACE, 8, edificio2.getId());
//        Postazione postazione2Edificio2 = postazioneService.savePostazione("Sala per riunioni dotata di monitor", TipoPostazione.SALA_RIUNIONI, 15, edificio2.getId());
//        Postazione postazione3Edificio2 = postazioneService.savePostazione("Postazione privata posizione tranquilla", TipoPostazione.PRIVATO, 3, edificio2.getId());
//
//        Postazione postazione1Edificio3 = postazioneService.savePostazione("Open space molto illuminato", TipoPostazione.OPENSPACE, 2, edificio3.getId());
//        Postazione postazione2Edificio3 = postazioneService.savePostazione("Sala per riunioni con proiettore", TipoPostazione.SALA_RIUNIONI, 6, edificio3.getId());
//        Postazione postazione3Edificio3 = postazioneService.savePostazione("Postazione privata con 2 letti matrimonali e uno singolo", TipoPostazione.PRIVATO, 5, edificio3.getId());
//
//        Utente utente1 = utenteService.saveUser("maria.regina", "Maria", "Regina", "maria.regina@gmail.com");
//        Utente utente2 = utenteService.saveUser("lollo.squeit", "Lorenzo", "Scuotto", "lorenzo.scuotto@gmail.com");
//        Utente utente3 = utenteService.saveUser("matteo.r", "Matteo", "Rocca", "matteo.rocca@gmail.com");
//
//        prenotazioneService.savePrenotazione(LocalDate.now().plusDays(1), utente1.getUsername(), postazione1Edificio1.getId());
//        prenotazioneService.savePrenotazione(LocalDate.now().plusDays(2), utente2.getUsername(), postazione2Edificio2.getId());
//        prenotazioneService.savePrenotazione(LocalDate.now().plusDays(3), utente3.getUsername(), postazione3Edificio3.getId());

        List<Postazione> trovate = postazioneService.cercaPerTipoECittà(TipoPostazione.OPENSPACE, "Milano");
        trovate.forEach(p -> System.out.println("Postazione trovata: " + p));
    }
}