package cm.oca.idealrent.Logement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class StandardController {

    public final StandardRespository standardRespository;

    public StandardController(StandardRespository standardRespository){
        this.standardRespository = standardRespository;
    }

    @GetMapping("/Standard/ListStandard")
    public List<Standard> findAll(){
        return standardRespository.findAll();
    }

    @PostMapping("/Standard/Inscription")
    public ResponseEntity<Object> save (@RequestBody Standard standard){

        standardRespository.save(standard);
        return ResponseEntity.ok("Enregistrement effectué");

    }
}
