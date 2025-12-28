package com.E_votersApp.E_votersApp.data.repositories;

import com.E_votersApp.E_votersApp.data.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
