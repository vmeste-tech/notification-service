package ru.kolpakovee.notification_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "notification_settings")
public class NotificationSettingEntity {
    @Id
    private UUID userId;
    private boolean taskEnabled = true;
    private boolean financeEnabled = true;
    private boolean penaltyEnabled = true;
    private boolean ruleEnabled = true;
    private boolean userEnabled = true;
}
