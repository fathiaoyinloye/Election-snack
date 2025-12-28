package com.E_votersApp.E_votersApp.dtos.response;

import com.E_votersApp.E_votersApp.data.models.PollOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CastPollResponse {
    private Long pollId;
    private Long EmployeeId;
    private String pollOption;
}
