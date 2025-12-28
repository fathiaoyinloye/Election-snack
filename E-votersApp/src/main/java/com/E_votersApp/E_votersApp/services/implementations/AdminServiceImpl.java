package com.E_votersApp.E_votersApp.services.implementations;

import com.E_votersApp.E_votersApp.data.models.Admin;
import com.E_votersApp.E_votersApp.data.models.Employee;
import com.E_votersApp.E_votersApp.data.models.Poll;
import com.E_votersApp.E_votersApp.data.repositories.AdminRepository;
import com.E_votersApp.E_votersApp.data.repositories.EmployeeRepository;
import com.E_votersApp.E_votersApp.data.repositories.PollRepository;
import com.E_votersApp.E_votersApp.dtos.requests.AddEmployeeRequest;
import com.E_votersApp.E_votersApp.dtos.requests.CreatePollRequest;
import com.E_votersApp.E_votersApp.dtos.requests.RegisterAdminRequest;
import com.E_votersApp.E_votersApp.dtos.response.AddEmployeeResponse;
import com.E_votersApp.E_votersApp.dtos.response.AddPollResponse;
import com.E_votersApp.E_votersApp.dtos.response.RegisterAdminResponse;
import com.E_votersApp.E_votersApp.dtos.response.ShowPollResponse;
import com.E_votersApp.E_votersApp.exceptions.AdminAlreadyExistException;
import com.E_votersApp.E_votersApp.services.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;
    private final PollRepository pollRepository;

    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest registerAdminRequest) {
        Admin checkAdmin =  adminRepository.findByUsername(registerAdminRequest.getUsername());
        if(checkAdmin != null) throw new AdminAlreadyExistException();
        Admin admin = new Admin();
        admin.setUsername(registerAdminRequest.getUsername());
        admin.setPassword(registerAdminRequest.getPassword());
        admin = adminRepository.save(admin);
        RegisterAdminResponse response = new RegisterAdminResponse();
        response.setUsername(admin.getUsername());
        response.setPassword(admin.getPassword());
        response.setId(admin.getAdminId());
        return response;
    }

    @Override
    public AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = new Employee();
        employee.setName(addEmployeeRequest.getName());
        employee = employeeRepository.save(employee);
        AddEmployeeResponse employeeResponse = new AddEmployeeResponse();
        employeeResponse.setName(employee.getName());

        return employeeResponse;
    }

    @Override
    public AddPollResponse createPoll(CreatePollRequest addPollRequest) {
        Poll poll = new Poll();
        poll.setName(addPollRequest.getName());
        poll.setOptions(addPollRequest.getOptions());
        poll = pollRepository.save(poll);
        return new AddPollResponse(poll.getId(), poll.getName(), poll.getOptions());
    }

    @Override
    public void deletePoll(Long id){
        pollRepository.deleteById(id);
    }

    @Override
    public List <ShowPollResponse> showPoll(){
        List<Poll> allElement = pollRepository.findAll();
       List <ShowPollResponse> pollResponse = new ArrayList<>();
        for(int count = 0; count < allElement.size(); count++){

            pollResponse.add(new ShowPollResponse(
                    allElement.get(count).getId(),
                    allElement.get(count).getName(),
                    allElement.get(count).getOptions()));
        }

return pollResponse;
}

}
