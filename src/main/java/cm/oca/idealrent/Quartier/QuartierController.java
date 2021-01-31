package cm.oca.idealrent.Quartier;

import cm.oca.idealrent.Logement.Logement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class QuartierController {

    public final QuartierRespository quartierRespository;

    public QuartierController(QuartierRespository quartierRespository){
        this.quartierRespository = quartierRespository;
    }

    @GetMapping("/Quartier/ListQuartier")
    public List<Quartier> findAll(){
        return quartierRespository.findAll();
    }


    @GetMapping("/Quartier/UnQuartier/{IdQuar}")
    public ResponseEntity<Object> findById (@PathVariable Long IdQuar){
        Optional<Quartier> quartier = quartierRespository.findById(IdQuar);
        if (quartier.isPresent()){
            return ResponseEntity.ok(quartier.get());
        }
        else {
            return ResponseEntity.badRequest().body("Ce quartier est introuvable!");
        }
    }

    @PostMapping("/Quartier/Inscription")
    public ResponseEntity<Object> save (@RequestBody Quartier quartier){

        quartierRespository.save(quartier);
        return ResponseEntity.ok("Enregistrement effectué");

    }
}
