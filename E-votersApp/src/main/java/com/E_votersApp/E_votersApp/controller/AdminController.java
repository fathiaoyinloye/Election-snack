package com.E_votersApp.E_votersApp.controller;

import com.E_votersApp.E_votersApp.dtos.requests.AddEmployeeRequest;
import com.E_votersApp.E_votersApp.dtos.requests.CreatePollRequest;
import com.E_votersApp.E_votersApp.dtos.requests.RegisterAdminRequest;
import com.E_votersApp.E_votersApp.exceptions.AdminAlreadyExistException;
import com.E_votersApp.E_votersApp.services.interfaces.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterAdminRequest request) {
        try{
            return ResponseEntity.status(CREATED).body(adminService.registerAdmin(request));
        }catch (AdminAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody AddEmployeeRequest request) {
        return ResponseEntity.status(CREATED).body(adminService.addEmployee(request));
    }


    @PostMapping("/createPoll")
    public ResponseEntity<?> createPoll(@RequestBody CreatePollRequest request) {
        return ResponseEntity.status(CREATED).body(adminService.createPoll(request));

    }

    @GetMapping("/showPoll")
    public ResponseEntity<?> showPoll() {
        return ResponseEntity.status(OK).body(adminService.showPoll());
    }


    @DeleteMapping("/deletePoll/{id}")
    public ResponseEntity<String> deletePoll(@PathVariable Long id) {
        adminService.deletePoll(id);
        return ResponseEntity.ok("Poll deleted successfully");
    }


}
