package ru.kolpakovee.notification_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.kolpakovee.notification_service.entities.NotificationSettingEntity;
import ru.kolpakovee.notification_service.records.NotificationSettingDto;

@Mapper
public interface NotificationSettingMapper {

    NotificationSettingMapper INSTANCE = Mappers.getMapper(NotificationSettingMapper.class);

    NotificationSettingDto toDto(NotificationSettingEntity entity);

    NotificationSettingEntity toEntity(NotificationSettingDto entity);

}
