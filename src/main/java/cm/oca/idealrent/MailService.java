package cm.oca.idealrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String text) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject("IdealRent");
        mail.setText(text);
        javaMailSender.send(mail);
    }

}
