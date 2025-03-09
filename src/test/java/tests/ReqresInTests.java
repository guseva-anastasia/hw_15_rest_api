package tests;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class ReqresInTests extends TestBase {

    UserModel user = new UserModel();

    @Test
    @DisplayName("Проверка успешного создания пользователя")
    void createUserTest  (){
        user.setName("Dmitry");
        user.setJob("leader");
        given()
                .body(user)
                .when()
                .log().uri()
                .log().body()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201);
    }

    @Test
    @DisplayName("Проверка успешного получения данных пользователя")
    void getUserDateTest  (){
        String userId = "2";
        given()
                .when()
                .log().uri()
                .get("/users/"+userId)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка получения данных несуществующего пользователя")
    void getNonExistentUserDateTest  (){
        String userId = "23";
        given()
                .when()
                .log().uri()
                .get("/users/"+userId)
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    @Test
    @DisplayName("Проверка успешного изменения пользователя")
    void updateUserTest (){
        String userId = "2";
        user.setName("Ivan");
        user.setJob("QA Lead");
        given()
                .body(user)
                .when()
                .log().uri()
                .put("/users/" + userId)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка успешного удаления пользователя")
    void deleteUserTest (){
        String userId = "2";

        given()
                .when()
                .log().uri()
                .delete("/users/" + userId)
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

}
