package models.book_store;

import lombok.Data;

@Data
public class GenerateTokenResponseModel {
    String token,expires,status,result;
}
