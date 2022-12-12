package com.medicalclinic.Medical.Clinic.Demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Appointment")
public class CreateAppointment {
    @Id
    @Column(name = "id", nullable = false)
    private int patientId;
    @Column(name = "PATIENT_NAME")
    private String patientName;
    @Column(name = "REASON")
    private String reason;
    @Column(name = "DATE")
    private String date;
    @Column(name = "STATUS")
    private String status;

}
