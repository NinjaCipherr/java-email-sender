package io.NinjaCipherr.mailSender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequest {
    public EmailRequest() {
    }

    public EmailRequest(String to, String subject, String body) {
        this.body = body;
        this.to = to;
        this.subject = subject;
    }

    @NotBlank(message = "Recipient is required")
    private String to;// recipientemail to send

    @NotBlank(message = " Subject of is required")
    private String subject; // body
    @NotBlank(message = " Body of email is required")
    private String body;// body text

}
