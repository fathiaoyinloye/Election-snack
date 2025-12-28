package com.E_votersApp.E_votersApp.services.interfaces;

import com.E_votersApp.E_votersApp.dtos.requests.CastPollRequest;
import com.E_votersApp.E_votersApp.dtos.response.CastPollResponse;
import com.E_votersApp.E_votersApp.dtos.response.ShowPollResponse;

import java.util.List;

public interface EmployeeService {

    CastPollResponse castAVote(CastPollRequest castPollRequest);
    List<ShowPollResponse> showPoll();

}
