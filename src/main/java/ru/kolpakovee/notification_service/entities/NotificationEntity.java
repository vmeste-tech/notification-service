package ru.kolpakovee.notification_service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.kolpakovee.notification_service.enums.NotificationCategory;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationCategory category;
    private boolean read = false;
    private LocalDateTime timestamp;
}
