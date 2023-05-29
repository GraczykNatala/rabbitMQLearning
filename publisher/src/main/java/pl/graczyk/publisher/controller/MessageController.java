package pl.graczyk.publisher.controller;

import org.springframework.web.bind.annotation.*;
import pl.graczyk.publisher.service.NotificationService;

@RestController
public class MessageController {

    private final NotificationService notificationService;


    public MessageController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public String sendStudentNotification(@RequestParam Long studentId) {
        notificationService.sendStudentNotification(studentId);
        return "Wiadomość została wysłana do studenta o id: " + studentId;
    }
}
