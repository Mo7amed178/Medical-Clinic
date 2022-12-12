package com.medicalclinic.Medical.Clinic.Demo.repository;

import com.medicalclinic.Medical.Clinic.Demo.model.CreateAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<CreateAppointment, Long> {
    Optional<CreateAppointment> findByPatientNameAndStatus(String patientName , String status);
    List<CreateAppointment> findByPatientName(String patientName);
    List<CreateAppointment> findByDate(Date date);
}
