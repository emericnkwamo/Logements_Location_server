package cm.oca.idealrent.Suscriber;

import cm.oca.idealrent.Logement.Logement;
import cm.oca.idealrent.MailService;
import org.hibernate.criterion.Distinct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CompteController{

            @Autowired
            private MailService mailService;
            private final CompteRespository compteRespository;


            public CompteController(SuscriberRespository suscriberRespository, CompteRespository compteRespository){
                this.compteRespository = compteRespository;

            }

            @GetMapping("/Compte/ListCompte")
            public List<Compte> findAll(){
                return compteRespository.findAll();
            }

            @PutMapping("/Compte/Souscrire/{IdComp}")
            public ResponseEntity<Object> save (@RequestBody Logement logement, @PathVariable Long IdComp, Compte compte){
                Optional<Compte> Comp = compteRespository.findById(IdComp);
                if (Comp.isPresent()){
                    compte = Comp.get();
                    String to = "emericnkwamo@gmail.com";
                    compte.souscriptions.add(logement);
                    compteRespository.save(compte);
                    String text = "le compte numéro "+IdComp+" vient de souscrire au logement numéro "+logement.getId_logement()+"; et attend une confirmation de visite.";
                    mailService.sendMail(to,text);
                    String to1 = compte.getSuscriber().getEmail();
                    String text1 = "Vous venez de souscrire à un logement sur la plateforme IdealRent via cet adresse." +
                            " Les responsables étudient votre dossier, et vous envorons un mail de reponse plustard! Nous vous remercions donc pour votre patience!" +
                            " IdealRent vous remerci!!!";
                    mailService.sendMail(to1,text1);
                    return ResponseEntity.ok("Souscription effectuée");
                }
                else{
                    return ResponseEntity.badRequest().body("Ce compte est introuvable!");
                }

            }

    @GetMapping("/Compte/ListSouscription/{IdComp}")
    public ResponseEntity<Object> findById (@PathVariable Long IdComp){
        Optional<Compte> compte = compteRespository.findById(IdComp);
        if (compte.isPresent()){
            Compte compte1 = compte.get();
            return ResponseEntity.ok(compte1.getSouscriptions());
        }
        else {
            return ResponseEntity.badRequest().body("Cet utilisateur est introuvable!");
        }
    }



}
