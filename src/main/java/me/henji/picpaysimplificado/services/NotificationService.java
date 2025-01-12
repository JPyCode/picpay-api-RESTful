package me.henji.picpaysimplificado.services;

import me.henji.picpaysimplificado.domain.user.User;
import me.henji.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class NotificationService {
    private RestTemplate restTemplate;
    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Erro ao enviar a notificação.");
            throw new Exception("Serviço de notificação fora do ar.");
        }
    }
}
