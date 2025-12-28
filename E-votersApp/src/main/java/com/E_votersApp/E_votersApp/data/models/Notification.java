package com.E_votersApp.E_votersApp.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "notification")
public class Notification {
    @Id
    private Long id;
    private LocalDateTime timeCreated;
    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;
    private boolean addNewPoll;
    private StringBuilder result;
}
