package models.book_store;
import lombok.Data;

@Data
public class CreateUserRequestModel {
    String userName, password;
}
