package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
