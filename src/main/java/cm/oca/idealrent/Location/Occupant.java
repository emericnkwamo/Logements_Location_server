package cm.oca.idealrent.Location;

import cm.oca.idealrent.Logement.Logement;
import cm.oca.idealrent.Suscriber.Suscriber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Occupant extends Suscriber implements Serializable {

    @NotNull
    private String appreciation;
    @NotNull
    private int bien_occupe;
    @ManyToMany
    private List<Logement> logements;

}
