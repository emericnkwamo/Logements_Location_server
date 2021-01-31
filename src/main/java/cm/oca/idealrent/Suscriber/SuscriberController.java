package cm.oca.idealrent.Suscriber;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SuscriberController {

            private final SuscriberRespository suscriberRespository;
            private final CompteRespository compteRespository;

            public SuscriberController(SuscriberRespository suscriberRespository, CompteRespository compteRespository){
                this.suscriberRespository = suscriberRespository;
                this.compteRespository = compteRespository;

            }


            @GetMapping("/Suscriber/ListSuscriber")
            public List<Suscriber> findAll(){
                return suscriberRespository.findAll();
            }


            @GetMapping("/Suscriber/UnSuscriber/{IdSus}")
            public ResponseEntity<Object> findById (@Valid @PathVariable Long IdSus){
                Optional<Suscriber> suscriber = suscriberRespository.findById(IdSus);
                if (suscriber.isPresent()){
                    return ResponseEntity.ok(suscriber.get());
                }
                else {
                    return ResponseEntity.badRequest().body("Cet utilisateur est introuvable!");
                }
            }

            @PostMapping("/Suscriber/Inscription")
            public ResponseEntity<Object> save (@RequestBody Suscriber suscriber, Compte compte){
                compte.setSuscriber(suscriber);
                compte.setLogin(suscriber.getPseudo());
                compte.setPassword(suscriber.getPassword());
                suscriberRespository.save(suscriber);
                compteRespository.save(compte);
                return ResponseEntity.ok("Enregistrement effectué");

            }

}
