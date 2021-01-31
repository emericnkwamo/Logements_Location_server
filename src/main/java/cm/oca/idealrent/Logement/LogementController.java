package cm.oca.idealrent.Logement;

import cm.oca.idealrent.Suscriber.Compte;
import cm.oca.idealrent.Suscriber.CompteRespository;
import cm.oca.idealrent.Suscriber.Suscriber;
import cm.oca.idealrent.Suscriber.SuscriberRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LogementController {

    private final LogementRespository logementRespository;

    public LogementController(LogementRespository logementRespository){
        this.logementRespository = logementRespository;
    }


    @GetMapping("/Logement/ListLogement")
    public List<Logement> findAll(){
        return logementRespository.findAll();
    }


    @GetMapping("/Logement/UnLogement/{IdLog}")
    public ResponseEntity<Object> findById (@PathVariable Long IdLog){
        Optional<Logement> logement = logementRespository.findById(IdLog);
        if (logement.isPresent()){
            return ResponseEntity.ok(logement.get());
        }
        else {
            return ResponseEntity.badRequest().body("Ce logement est introuvable!");
        }
    }

    @PostMapping("/Logement/Inscription")
    public ResponseEntity<Object> save (@Valid @RequestBody Logement logement){

        logement.setDate_ajout(Date.from(Instant.now()));
        logementRespository.save(logement);
        return ResponseEntity.ok("Enregistrement effectué");

    }


}
