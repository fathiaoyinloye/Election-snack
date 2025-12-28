package com.E_votersApp.E_votersApp.services.implementations;

import com.E_votersApp.E_votersApp.data.models.Employee;
import com.E_votersApp.E_votersApp.data.models.Poll;
import com.E_votersApp.E_votersApp.data.models.PollOption;
import com.E_votersApp.E_votersApp.data.repositories.EmployeeRepository;
import com.E_votersApp.E_votersApp.data.repositories.PollRepository;
import com.E_votersApp.E_votersApp.dtos.requests.CastPollRequest;
import com.E_votersApp.E_votersApp.dtos.response.CastPollResponse;
import com.E_votersApp.E_votersApp.dtos.response.ShowPollResponse;
import com.E_votersApp.E_votersApp.exceptions.EmployeeDoesNotExistException;
import com.E_votersApp.E_votersApp.exceptions.InvalidPollOptionException;
import com.E_votersApp.E_votersApp.exceptions.PollDoesNotExistException;
import com.E_votersApp.E_votersApp.services.interfaces.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  EmployeeRepository employeeRepository;
    private PollRepository pollRepository;

    @Override
    public CastPollResponse castAVote(CastPollRequest castPollRequest){

    Employee employee = employeeRepository.findById(castPollRequest.getEmployeeId()).get();
    if(employee == null) throw new EmployeeDoesNotExistException();
    Poll poll = pollRepository.findById(castPollRequest.getPollId()).get();
    if(poll == null) throw new PollDoesNotExistException();
    List<PollOption> pollOption =  poll.getOptions();
    boolean findPollOption = false;
    for(PollOption option : pollOption) {
        if (option.getName().equalsIgnoreCase(castPollRequest.getPollOption())) {
            findPollOption = true;
            option.setVotes(option.getVotes() + 1);
            pollRepository.save(poll);

        }
    }
    if(!findPollOption) throw new InvalidPollOptionException();

    return   new CastPollResponse(poll.getId(), employee.getEmployeeId() ,poll.getName());

    }

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
