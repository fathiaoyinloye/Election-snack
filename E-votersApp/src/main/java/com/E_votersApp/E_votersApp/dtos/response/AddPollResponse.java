package com.E_votersApp.E_votersApp.dtos.response;


import com.E_votersApp.E_votersApp.data.models.PollOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class AddPollResponse {
    private Long id;
    private String name;
    private List<PollOption> options;

}
