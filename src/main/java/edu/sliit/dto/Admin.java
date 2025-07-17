package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private Integer id;
    private String adminName;
    private String adminContact;
    private String adminAddress;
    private String adminEmail;
}
