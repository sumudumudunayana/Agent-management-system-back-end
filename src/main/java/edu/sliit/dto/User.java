package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String userFirstName;
    private String userLastMame;
    private String userAddress;
    private String userEmail;
    private String userPhoneNumber;
    private String userDate;
}
