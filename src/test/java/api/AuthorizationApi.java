package api;

import helpers.TestData;
import io.qameta.allure.Step;
import models.book_store.AuthorizationResponseModel;
import models.book_store.CreateUserRequestModel;
import models.book_store.CreateUserResponseModel;
import models.book_store.GenerateTokenResponseModel;
import static io.restassured.RestAssured.given;
import static specs.ApiSpecs.*;

public class AuthorizationApi {


    public static CreateUserRequestModel registrationBody(){
        CreateUserRequestModel user = new CreateUserRequestModel();

        TestData testData = new TestData();

        user.setUserName(testData.userName);
        user.setPassword(testData.userPassword);

        return user;


    }

    @Step("Регистрация через API")
    public static CreateUserResponseModel registration(CreateUserRequestModel user){

        return
                given(requestSpec)
                        .body(user)
                        .when()
                        .post("/Account/v1/User")
                        .then()
                        .spec(statusCode201Spec)
                        .extract().as(CreateUserResponseModel.class);

    }

    @Step("Генерация токена через API")
    public static GenerateTokenResponseModel token(CreateUserRequestModel user){
        return
                given(requestSpec)
                        .body(user)
                        .when()
                        .post("/Account/v1/GenerateToken")
                        .then()
                        .spec(statusCode200Spec)
                        .extract().as(GenerateTokenResponseModel.class);

    }


    @Step("Авторизация через API")
    public static AuthorizationResponseModel auth(CreateUserRequestModel user){
        return
                given(requestSpec)
                        .body(user)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .spec(statusCode200Spec)
                        .extract().as(AuthorizationResponseModel.class);

    }


    public AuthorizationResponseModel createNewUserTest(){
        CreateUserRequestModel body = AuthorizationApi.registrationBody();
        CreateUserResponseModel registration = AuthorizationApi.registration(body);
        GenerateTokenResponseModel token = AuthorizationApi.token(body);
        AuthorizationResponseModel auth = AuthorizationApi.auth(body);

        return auth;
    }
}
