package com.medicalclinic.Medical.Clinic.Demo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CancelAppointmentResDTO {
    private String patientName;
    private String status;
    private String reason;
}
