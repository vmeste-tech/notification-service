package ru.kolpakovee.notification_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kolpakovee.notification_service.entities.NotificationEntity;
import ru.kolpakovee.notification_service.records.NotificationDto;
import ru.kolpakovee.notification_service.records.NotificationEvent;

@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "read", constant = "false")
    NotificationEntity toEntity(NotificationEvent event);

    NotificationDto toDto(NotificationEntity entity);
}