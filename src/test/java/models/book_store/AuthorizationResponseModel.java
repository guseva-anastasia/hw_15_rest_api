package models.book_store;

import lombok.Data;

@Data
public class AuthorizationResponseModel {
    String userId,username,password,token,expires,created_date,isActive;
}
