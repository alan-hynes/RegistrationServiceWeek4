package ie.atu.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegistrationController {
    private final NotificationService notificationService;

    @Autowired
    public RegistrationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> handleRegistrationRequests(@RequestBody UserDetails userDetails) {
        System.out.println("User Details received at Registration Controller: " + userDetails);
        return notificationService.notifyUser(userDetails);
    }
}
