package ru.kolpakovee.notification_service.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.kolpakovee.notification_service.records.NotificationSettingDto;
import ru.kolpakovee.notification_service.services.NotificationSettingService;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/notification/setting")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Управление настройками уведомлений", description = "API для управления настройками уведомлений")
public class NotificationSettingController {

    private final NotificationSettingService settingService;

    @GetMapping
    public NotificationSettingDto getSetting(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        return settingService.getSetting(UUID.fromString(userId));
    }

    @PutMapping("/update")
    public NotificationSettingDto updateSetting(@RequestBody NotificationSettingDto request) {
        return settingService.updateSetting(request);
    }
}
