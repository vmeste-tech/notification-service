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
    private boolean taskEnabled = false;
    private boolean financeEnabled = false;
    private boolean penaltyEnabled = false;
    private boolean ruleEnabled = false;
    private boolean userEnabled = false;
}
