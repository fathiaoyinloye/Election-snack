package com.E_votersApp.E_votersApp.dtos.requests;

import com.E_votersApp.E_votersApp.data.models.PollOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class CreatePollRequest {
    private String name;
    private List<PollOption> options;
}
