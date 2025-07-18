package daviderocca.U5_W1_D5.entities;

import daviderocca.U5_W1_D5.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descrizione;

    @Column(name = "tipo_postazione")
    private TipoPostazione tipoPostazione;

    @Column(name = "numero_massimo_persone")
    private int numeroMassimoPersone;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroMassimoPersone, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMassimoPersone = numeroMassimoPersone;
        this.edificio = edificio;
    }

    public long getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public int getNumeroMassimoPersone() {
        return numeroMassimoPersone;
    }

    public void setNumeroMassimoPersone(int numeroMassimoPersone) {
        this.numeroMassimoPersone = numeroMassimoPersone;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMassimoPersone=" + numeroMassimoPersone +
                ", edificio=" + edificio +
                '}';
    }
}
