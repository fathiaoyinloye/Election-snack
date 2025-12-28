package com.E_votersApp.E_votersApp.data.repositories;


import com.E_votersApp.E_votersApp.data.models.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
}
