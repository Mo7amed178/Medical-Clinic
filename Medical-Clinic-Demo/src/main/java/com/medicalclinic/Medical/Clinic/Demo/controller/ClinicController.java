package com.medicalclinic.Medical.Clinic.Demo.controller;

import com.medicalclinic.Medical.Clinic.Demo.model.*;
import com.medicalclinic.Medical.Clinic.Demo.service.ClinicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ClinicController", description = "REST APIs related to Medical Clinic")
@RestController
@RequestMapping("/MedicalClinic")
public class ClinicController {

    ClinicService clinicService;

    public ClinicController (ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ApiOperation(value = "Create Appointment  ", response = CreateAppointment.class)
    @PostMapping("/createAppointment")
    public ResponseEntity<CreateAppointment> createAppointment (@RequestBody CreateAppointmentReqDTO reqDTO) {
        System.out.println("Create Appointment Started");
        CreateAppointment resDTO = clinicService.createAppointment(reqDTO);
        System.out.println("Create Appointment Finished");
        return new ResponseEntity<>(resDTO, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get list of Appointments ", response = CreateAppointment.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @GetMapping("/getAllAppointments")
    public ResponseEntity<List<CreateAppointment>> getAllAppointments () {
        System.out.println("Get All Appointments Started");
        List<CreateAppointment> res = clinicService.getAllAppointments();
        System.out.println("Get All Appointments Finished");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "Cancel Appointment  ", response = CancelAppointmentResDTO.class)
    @PostMapping("CancelAppointment")
    public ResponseEntity<CancelAppointmentResDTO> cancelAppointment(@RequestBody CancelAppointmentReqDTO reqDTO) {
        System.out.println("Cancel Appointment Started");
        CancelAppointmentResDTO res = clinicService.cancelAppointment(reqDTO);
        System.out.println("Cancel Appointment Finished");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Appointments By Patient Name  ", response = CreateAppointment.class)
    @GetMapping("/getAllAppointmentsByPatientName")
    public ResponseEntity<List<CreateAppointment>> getAllAppointmentsByPatientName(@RequestBody GetAllAppointmentsByPatientName reqDTO){
        System.out.println("Get AllAppointmentsByPatientName Started");
        List<CreateAppointment> res = clinicService.getAllAppointmentsByPatientName(reqDTO);
        System.out.println("Get AllAppointmentsByPatientName Finished");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Appointments By Date  ", response = CreateAppointment.class)
    @GetMapping("/getAllAppointmentsByDate")
    public ResponseEntity<List<CreateAppointment>> getAllAppointmentsByDate(@RequestBody GetAllAppointmentsByDate reqDTO){
        System.out.println("Get AllAppointmentsByPatientName Started");
        List<CreateAppointment> res = clinicService.getAllAppointmentsByDate(reqDTO);
        System.out.println("Get AllAppointmentsByPatientName Finished");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
