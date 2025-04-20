package ru.kolpakovee.notification_service.records;

import java.util.UUID;

public record NotificationSettingDto(
        UUID userId,
        boolean taskEnabled,
        boolean financeEnabled,
        boolean penaltyEnabled,
        boolean ruleEnabled,
        boolean userEnabled
) {
}
