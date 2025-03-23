package api;

import io.qameta.allure.Step;
import models.book_store.AuthorizationResponseModel;

import static io.restassured.RestAssured.given;
import static specs.ApiSpecs.requestSpec;
import static specs.ApiSpecs.statusCode204Spec;

public class DeletedBookApi {
    @Step("Удаление всех книг из профиля через API")
    public void deleteAllBooks(AuthorizationResponseModel authDate) {
        given(requestSpec)
                .header("Authorization", "Bearer " + authDate.getToken())
                .queryParam("UserId", authDate.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(statusCode204Spec);
    }
}
