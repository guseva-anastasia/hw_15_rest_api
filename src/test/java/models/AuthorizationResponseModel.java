package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationResponseModel {

    @JsonProperty("created_date")

    String userId, username, password, token, expires, createdDate, isActive;
}
