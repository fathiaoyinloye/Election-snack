package com.E_votersApp.E_votersApp.data.repositories;


import com.E_votersApp.E_votersApp.data.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {

}
