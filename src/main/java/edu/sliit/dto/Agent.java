package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agent {
    private Integer id;
    private String agentName;
    private String agentContact;
    private String agentAddress;
    private String agentEmail;
    private Integer agentRating;
    private String agentDate;
}
