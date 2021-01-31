package cm.oca.idealrent.Suscriber;

import cm.oca.idealrent.Logement.Logement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id_compte;
    private String login;
    private String password;
    @ManyToOne
    private Suscriber suscriber;
    @ManyToMany
    public List<Logement> souscriptions;

    public void setSouscriptions(List<Logement> souscriptions) {
        this.souscriptions = souscriptions;
    }

    public void setSuscriber(Suscriber suscriber) {
        this.suscriber = suscriber;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Suscriber getSuscriber() {
        return suscriber;
    }

    public List<Logement> getSouscriptions() {
        return souscriptions;
    }
}
