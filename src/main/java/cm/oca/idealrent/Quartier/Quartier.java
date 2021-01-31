package cm.oca.idealrent.Quartier;

import cm.oca.idealrent.Localite.Localite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
public class Quartier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id_quartier;
    private String nom_quartier;
    @NotNull
    @ManyToOne
    private Localite localite;

}
