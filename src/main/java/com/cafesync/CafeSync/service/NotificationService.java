package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Notification;

public interface NotificationService {

    Notification saveNotification(Notification notification);

    List<Notification> getAllNotifications();

    Optional<Notification> getNotificationById(Long id);

    Notification updateNotification(Notification notification);

    void deleteNotification(Long id);

}