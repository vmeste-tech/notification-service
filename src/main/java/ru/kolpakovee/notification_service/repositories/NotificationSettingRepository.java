package ru.kolpakovee.notification_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolpakovee.notification_service.entities.NotificationSettingEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationSettingRepository extends JpaRepository<NotificationSettingEntity, UUID> {
    Optional<NotificationSettingEntity> findByUserId(UUID userId);
}
