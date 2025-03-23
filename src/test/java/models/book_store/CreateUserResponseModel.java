package models.book_store;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserResponseModel {
    String userID,username;
    List books;
}
