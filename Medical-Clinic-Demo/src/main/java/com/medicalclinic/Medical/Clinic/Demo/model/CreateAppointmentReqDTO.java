package com.medicalclinic.Medical.Clinic.Demo.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAppointmentReqDTO {
    private String patientName;
    private String reason;
    private String date;
}
