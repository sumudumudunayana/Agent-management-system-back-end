package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {
    private Integer id;
    private String appointmentTitle;
    private String appointmentDate;
    private String appointmentCreatedBy;
    private String appointmentStatus;
}
