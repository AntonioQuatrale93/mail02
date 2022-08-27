package it.develhope.Mail02.controller;

import it.develhope.Mail02.dto.NotificationDto;
import it.develhope.Mail02.entities.Student;
import it.develhope.Mail02.service.EmailService;
import it.develhope.Mail02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EmailService emailService;


    @PostMapping
    public ResponseEntity sendmail(@RequestBody @Valid NotificationDto notificationDto) {
        try {
            Student studentToSendMail = studentService.getById(notificationDto.getContactId());
            if (studentToSendMail == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("student not found");
            }
            emailService.sendTo(studentToSendMail.getEmail(), notificationDto.getTitle(), notificationDto.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("wrong payload");
        }

    }
}
