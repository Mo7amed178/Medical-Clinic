package com.medicalclinic.Medical.Clinic.Demo.service;

import com.medicalclinic.Medical.Clinic.Demo.model.*;
import com.medicalclinic.Medical.Clinic.Demo.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    AppointmentRepository appointmentRepository;

    public ClinicService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public CreateAppointment createAppointment (CreateAppointmentReqDTO reqDTO) {

        CreateAppointment resDTO = CreateAppointment.builder().build();
        resDTO.setPatientName(reqDTO.getPatientName());
        resDTO.setReason(reqDTO.getReason());
        resDTO.setDate(reqDTO.getDate());
        appointmentRepository.save(resDTO);

        return resDTO;
    }

    public List<CreateAppointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public CancelAppointmentResDTO cancelAppointment (CancelAppointmentReqDTO reqDTO) {
        Optional<CreateAppointment> resOpt = appointmentRepository.findByPatientNameAndStatus(reqDTO.getPatientName(), reqDTO.getStatus());

        CancelAppointmentResDTO resDTO = CancelAppointmentResDTO.builder().build();
        if(!resOpt.isPresent()) {
            System.out.println("This patient have no appointment with active status");
        } else  {
                    resDTO.setPatientName(reqDTO.getPatientName());
                    resDTO.setReason(reqDTO.getReason());
                    resDTO.setReason("Canceled");

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            CreateAppointment createAppointment = CreateAppointment.builder()
                            .patientName(reqDTO.getPatientName())
                            .reason("Canceled")
                            .date(timeStamp).build();
            appointmentRepository.save(createAppointment);

        }
        return resDTO;
    }

    public List<CreateAppointment> getAllAppointmentsByPatientName (GetAllAppointmentsByPatientName req) {
        List<CreateAppointment> res = appointmentRepository.findByPatientName(req.getPatientName());

        return res;
    }

    public List<CreateAppointment> getAllAppointmentsByDate (GetAllAppointmentsByDate req) {
        List<CreateAppointment> res = appointmentRepository.findByDate(req.getDate());

        return res;
    }

}
