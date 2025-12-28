package com.E_votersApp.E_votersApp.services.interfaces;

import com.E_votersApp.E_votersApp.dtos.requests.AddEmployeeRequest;
import com.E_votersApp.E_votersApp.dtos.requests.CreatePollRequest;
import com.E_votersApp.E_votersApp.dtos.requests.RegisterAdminRequest;
import com.E_votersApp.E_votersApp.dtos.response.AddEmployeeResponse;
import com.E_votersApp.E_votersApp.dtos.response.AddPollResponse;
import com.E_votersApp.E_votersApp.dtos.response.RegisterAdminResponse;
import com.E_votersApp.E_votersApp.dtos.response.ShowPollResponse;

import java.util.List;

public interface AdminService {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest);

    AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest);
    AddPollResponse createPoll(CreatePollRequest createPollRequest);
    List<ShowPollResponse> showPoll();
    void deletePoll(Long id);
}
