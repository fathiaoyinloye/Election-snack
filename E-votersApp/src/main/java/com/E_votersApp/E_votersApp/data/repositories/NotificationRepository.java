package com.E_votersApp.E_votersApp.data.repositories;

import com.E_votersApp.E_votersApp.data.models.Company;
import com.E_votersApp.E_votersApp.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
