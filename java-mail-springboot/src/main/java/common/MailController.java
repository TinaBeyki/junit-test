package common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("sendMail")
    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("tinabeyki98@gmail.com");
        mailMessage.setText("JavaMail");
        mailMessage.setText("Hi Tina this message was sent from your other email account :)");
        javaMailSender.send(mailMessage);
    }
}
