package cm.oca.idealrent.Localite;

import cm.oca.idealrent.Logement.Logement;
import cm.oca.idealrent.Logement.LogementRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LocaliteController {

    public final LocaliteRespository localiteRespository;

    public  LocaliteController(LocaliteRespository localiteRespository){
        this.localiteRespository = localiteRespository;
    }

    @GetMapping("/Localite/ListLocalite")
    public List<Localite> findAll(){
        return localiteRespository.findAll();
    }


    @GetMapping("/Localite/UnLocalite/{IdLoc}")
    public ResponseEntity<Object> findById (@Valid @PathVariable Long IdLoc){
        Optional<Localite> localite = localiteRespository.findById(IdLoc);
        if (localite.isPresent()){
            return ResponseEntity.ok(localite.get());
        }
        else {
            return ResponseEntity.badRequest().body("Ce logement est introuvable!");
        }
    }

    @PostMapping("/Localite/Inscription")
    public ResponseEntity<Object> save (@Valid @RequestBody Localite localite){

        localiteRespository.save(localite);
        return ResponseEntity.ok("Enregistrement effectué");

    }

}
