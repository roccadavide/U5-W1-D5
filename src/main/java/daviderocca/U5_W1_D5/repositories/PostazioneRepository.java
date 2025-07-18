package daviderocca.U5_W1_D5.repositories;

import daviderocca.U5_W1_D5.entities.Postazione;
import daviderocca.U5_W1_D5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    //sfruttando le Query method è stato abbastanza facile creare questo tipo di ricerca, tranne per il fatto del trattino basso per
    //dichiarare un attributo dentro un'attributo(cioè l'attributo edificio in postazione che ha sua volta ha l'attributo città)
    //questo me lo sono cercato e ora ho capito come funziona
    List<Postazione> findByTipoPostazioneAndEdificio_Città(TipoPostazione tipoPostazione, String città);

}
