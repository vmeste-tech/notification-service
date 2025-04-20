package ru.kolpakovee.notification_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolpakovee.notification_service.entities.NotificationSettingEntity;
import ru.kolpakovee.notification_service.mappers.NotificationSettingMapper;
import ru.kolpakovee.notification_service.records.NotificationSettingDto;
import ru.kolpakovee.notification_service.repositories.NotificationSettingRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationSettingService {

    private final NotificationSettingRepository repository;

    public NotificationSettingDto getSetting(UUID userId) {
        Optional<NotificationSettingEntity> entity = repository.findByUserId(userId);

        if (entity.isPresent()) {
            return NotificationSettingMapper.INSTANCE.toDto(entity.get());
        }

        NotificationSettingEntity newSetting = new NotificationSettingEntity();
        newSetting.setUserId(userId);
        repository.save(newSetting);
        return NotificationSettingMapper.INSTANCE.toDto(newSetting);
    }

    public NotificationSettingDto updateSetting(NotificationSettingDto setting) {
        NotificationSettingEntity settingEntity = NotificationSettingMapper.INSTANCE.toEntity(setting);
        return NotificationSettingMapper.INSTANCE.toDto(repository.save(settingEntity));
    }
}
