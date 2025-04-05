package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationResponseModel {

    @JsonProperty("created_date")
    private String createdDate;

    String userId, username, password, token, expires, isActive;
}
