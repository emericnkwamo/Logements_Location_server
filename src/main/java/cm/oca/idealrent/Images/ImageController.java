package cm.oca.idealrent.Images;

import cm.oca.idealrent.Logement.Logement;
import cm.oca.idealrent.Logement.LogementRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ImageController {

    public final ImageRespository imageRespository;

    public ImageController(ImageRespository imageRespository){
        this.imageRespository = imageRespository;
    }

    @PostMapping("/Images/Inscription")
    public ResponseEntity<Object> save (@RequestBody Image image){

        imageRespository.save(image);
        return ResponseEntity.ok("Enregistrement effectué");

    }
}
