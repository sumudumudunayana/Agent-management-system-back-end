package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    private Integer id;
    private String clientFirstName;
    private String clientLastName;
    private String clientAddress;
    private String clientEmail;
    private String clientPhoneNumber;
}
