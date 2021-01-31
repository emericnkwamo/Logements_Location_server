package cm.oca.idealrent.Logement;


import cm.oca.idealrent.Images.Image;
import cm.oca.idealrent.Quartier.Quartier;
import cm.oca.idealrent.Suscriber.Compte;
import cm.oca.idealrent.Suscriber.Suscriber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Logement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id_logement;
    @NotNull
    private int superficie;
    @ManyToOne
    private Quartier quartier;
    @ManyToOne
    private Standard standard;
    @NotNull
    private int loyer;
    @NotNull
    private String description;
    @NotNull
    @OneToOne
    private Image image;
    @NotNull
    private boolean disponible;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date_ajout;
    @OneToMany
    private List<Image> Photos;

    public long getId_logement() {
        return id_logement;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }
}
