package tests;
import models.CreateUserResponseModel;
import models.UpdateUserResponse;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import helpers.TestData;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.ApiSpecs.*;


public class ReqresInTests extends TestBase {

    UserModel user = new UserModel();
    TestData testData = new TestData();

    @Tag("reqres_in_tests")
    @Test
    @DisplayName("Проверка успешного создания пользователя")
    void createUserTest  (){
        user.setName(testData.userName);
        user.setJob(testData.userJob);
        CreateUserResponseModel response = step(
                "Создание пользователя",
                () -> given(requestSpec)
                        .body(user)
                        .when()
                        .post("/users")
                        .then()
                        .spec(statusCode201Spec)
                        .extract().as(CreateUserResponseModel.class));

        step("Проверяем ответ на запрос", () -> {
            assertThat(response.getName()).isEqualTo(user.getName());
            assertThat(response.getJob()).isEqualTo(user.getJob());
            assertThat(response.getId()).isNotNull();
            assertThat(response.getCreatedAt()).isNotNull();
        });

    }

    @Tag("reqres_in_tests")
    @Test
    @DisplayName("Проверка успешного получения данных пользователя")
    void getUserDateTest  (){
        String userId = "2";
        step ("Отправка запроса на получение данных пользователя", () -> {
            given(requestSpec)
                    .when()
                    .get("/users/"+userId)
                    .then()
                    .spec(statusCode200Spec);
        });

    }

    @Tag("reqres_in_tests")
    @Test
    @DisplayName("Проверка получения данных несуществующего пользователя")
    void getNonExistentUserDateTest  (){
        String userId = "23";
        step ("Отправка запроса на получение данных пользователя", () -> {
            given(requestSpec)
                    .when()
                    .get("/users/"+userId)
                    .then()
                    .spec(statusCode404Spec);
        });
    }

    @Tag("reqres_in_tests")
    @Test
    @DisplayName("Проверка успешного изменения пользователя")
    void updateUserTest (){
        String userId = "2";
        user.setName(testData.userName);
        user.setJob(testData.userJob);
        UpdateUserResponse response = step
                ("Отправка запроса на изменение данных пользователя", () ->
            given(requestSpec)
                    .body(user)
                    .when()
                    .put("/users/" + userId)
                    .then()
                    .spec(statusCode200Spec)
                    .extract().as(UpdateUserResponse.class));

        step ("Отправка запроса на изменение данных пользователя", () -> {
            assertThat(response.getName()).isEqualTo(user.getName());
            assertThat(response.getJob()).isEqualTo(user.getJob());
            assertThat(response.getUpdatedAt()).isNotNull();
        });
    }

    @Tag("reqres_in_tests")
    @Test
    @DisplayName("Проверка успешного удаления пользователя")
    void deleteUserTest (){
        String userId = "2";
        step("Отправка запроса на удаление пользователя",() ->{
            given(requestSpec)
                    .when()
                    .delete("/users/" + userId)
                    .then()
                    .spec(statusCode204Spec);
        });

    }

}
