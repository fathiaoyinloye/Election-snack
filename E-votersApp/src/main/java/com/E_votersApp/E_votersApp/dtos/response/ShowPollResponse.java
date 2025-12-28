package com.E_votersApp.E_votersApp.dtos.response;

import com.E_votersApp.E_votersApp.data.models.PollOption;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ShowPollResponse {
    private Long id;
    private String name;
    private List<PollOption> options;
}
