package cm.oca.idealrent.Suscriber;

import cm.oca.idealrent.Localite.Localite;
import cm.oca.idealrent.Logement.Logement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Suscriber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id_suscriber;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String nom_suscriber;
    @NotNull
    private String prenom_suscriber;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    @NotNull
    private int telephone;
    @NotNull
    private String pseudo;
    @NotNull
    private String password;

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
