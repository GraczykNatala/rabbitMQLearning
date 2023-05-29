package pl.graczyk.reciever;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;

@RestController
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/message")
    public String recieveMessage() {
        Object message = rabbitTemplate.receiveAndConvert("kurs");
        if(message != null) {
        return "Udało się pobrać wiadomość: " + message.toString();
    } else {
            return "Nie ma nowych wiadomości";
        }
    }

    @RabbitListener(queues = "kurs")
    public void messageListener(String message) {
        System.out.println(message);
    }
}
