package ru.kolpakovee.notification_service.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolpakovee.notification_service.entities.NotificationEntity;
import ru.kolpakovee.notification_service.mappers.NotificationMapper;
import ru.kolpakovee.notification_service.records.NotificationDto;
import ru.kolpakovee.notification_service.records.NotificationEvent;
import ru.kolpakovee.notification_service.repositories.NotificationRepository;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public List<NotificationDto> getNotifications(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(NotificationMapper.INSTANCE::toDto)
                .sorted(Comparator.comparing(NotificationDto::timestamp).reversed())
                .toList();
    }

    public NotificationDto readNotification(UUID notificationId) {
        NotificationEntity notification = repository.findById(notificationId)
                .orElseThrow(() -> new EntityNotFoundException(""));

        notification.setRead(true);

        return NotificationMapper.INSTANCE.toDto(repository.save(notification));
    }

    public void handle(NotificationEvent event) {
        NotificationEntity entity = NotificationMapper.INSTANCE.toEntity(event);
        repository.save(entity);
    }
}
