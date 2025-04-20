package ru.kolpakovee.notification_service.records;

import ru.kolpakovee.notification_service.enums.NotificationCategory;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationEvent(
        UUID userId,
        String message,
        NotificationCategory category,
        LocalDateTime timestamp
) {
}
