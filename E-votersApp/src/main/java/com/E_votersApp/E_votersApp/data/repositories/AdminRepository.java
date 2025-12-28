package com.E_votersApp.E_votersApp.data.repositories;

import com.E_votersApp.E_votersApp.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String name);
}
