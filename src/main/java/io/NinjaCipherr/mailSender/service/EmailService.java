package io.NinjaCipherr.mailSender.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import io.NinjaCipherr.mailSender.dto.EmailRequest;
import io.NinjaCipherr.mailSender.entity.Email;
import io.NinjaCipherr.mailSender.repository.EmailRepository;

/**
 * EmailService
 */
@Service
public class EmailService {
    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    public String sendEmail(EmailRequest emailRequest) {
        try {
            // trong project toi chi muon gui text email(dung cho viec hoc javamailsender)
            // cho nen toi da dung class simpleMailMessage();
            // link : https://qiita.com/ry-s/items/4ce9a5856461119a4718
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // luu y la con mimeMessage(ke thua tu javaMail api)

            simpleMailMessage.setTo(emailRequest.getTo());
            simpleMailMessage.setSubject(emailRequest.getSubject());
            simpleMailMessage.setText(emailRequest.getBody());
            javaMailSender.send(simpleMailMessage);

            // save to database
            Email emailToSave = new Email();
            emailToSave.setRecipient(emailRequest.getTo());
            emailToSave.setSubject(emailRequest.getSubject());
            emailToSave.setBody(emailRequest.getBody());
            emailRepository.save(emailToSave);
            return "Email successfully sent";
        } catch (Exception e) {
            return "da gap loi la " + e;
        }
    }
}