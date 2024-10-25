package io.NinjaCipherr.mailSender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.NinjaCipherr.mailSender.dto.EmailRequest;
import io.NinjaCipherr.mailSender.service.EmailService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailController {
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailRequest emailRequest) {

        return ResponseEntity.ok(emailService.sendEmail(emailRequest));
    }

}
