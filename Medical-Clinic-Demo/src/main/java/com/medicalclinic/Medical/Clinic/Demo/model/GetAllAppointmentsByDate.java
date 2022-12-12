package com.medicalclinic.Medical.Clinic.Demo.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllAppointmentsByDate {
    private Date date;
}
