package com.medicalclinic.Medical.Clinic.Demo.model;

import lombok.*;

import javax.swing.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CancelAppointmentReqDTO {
    private String patientName;
    private Long appointmentId;
    private String reason;
    private String status;
}
