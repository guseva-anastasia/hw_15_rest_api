package api;

import io.qameta.allure.Step;
import models.book_store.BookModelResponse;
import models.book_store.BooksCollectionResponse;

import static io.restassured.RestAssured.given;
import static specs.ApiSpecs.requestSpec;
import static specs.ApiSpecs.statusCode200Spec;

public class GetBookCollectionApi {
    @Step("Получение коллекции книг через API")
    public BooksCollectionResponse requestBookCollection() {
        return given(requestSpec)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(statusCode200Spec)
                .extract().as(BooksCollectionResponse.class);
    }
}
