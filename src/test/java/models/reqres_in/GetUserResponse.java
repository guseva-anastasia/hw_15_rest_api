package models.reqres_in;
import lombok.Data;

@Data
public class GetUserResponse {
    private DataUserModel data;
    private SupportUserModel support;
}
