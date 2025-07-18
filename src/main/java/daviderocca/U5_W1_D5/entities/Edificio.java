package daviderocca.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_edificio")
    private String nomeEdificio;

    private String indirizzo;

    private String città;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni = new ArrayList<>();

    public Edificio(String nomeEdificio, String indirizzo, String città) {
        this.nomeEdificio = nomeEdificio;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    public long getId() {
        return id;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public List<Postazione> getPostazioni() {
        return postazioni;
    }

    public void setPostazioni(List<Postazione> postazioni) {
        this.postazioni = postazioni;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nomeEdificio='" + nomeEdificio + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
