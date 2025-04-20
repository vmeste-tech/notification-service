package ru.kolpakovee.notification_service.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.kolpakovee.notification_service.records.NotificationDto;
import ru.kolpakovee.notification_service.services.NotificationService;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Управление квартирой", description = "API для управления квартирой")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    @Operation(summary = "Получение списка уведомлений",
            description = "Позволяет получить список уведомлений")
    public List<NotificationDto> getNotifications(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        return notificationService.getNotifications(UUID.fromString(userId));
    }

    @PatchMapping("/read/{notificationId}")
    @Operation(summary = "Обновление статуса уведомления",
            description = "Позволяет обновить статус уведомления")
    public NotificationDto readNotification(@PathVariable UUID notificationId) {
        return notificationService.readNotification(notificationId);
    }
}
