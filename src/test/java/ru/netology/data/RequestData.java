package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor


public class RequestData {
    private String login;
    private String password;
    private String status;

    public RequestData(String firstName, String password, String active) {

    }
}
