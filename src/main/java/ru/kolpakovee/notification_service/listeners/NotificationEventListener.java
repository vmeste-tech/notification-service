package ru.kolpakovee.notification_service.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kolpakovee.notification_service.records.NotificationEvent;
import ru.kolpakovee.notification_service.services.NotificationService;

@Service
@RequiredArgsConstructor
public class NotificationEventListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "system-events", groupId = "notification-group")
    public void onEvent(NotificationEvent event) {
        notificationService.handle(event);
    }
}
