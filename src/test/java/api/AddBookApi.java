package api;

import io.qameta.allure.Step;
import models.AddBookRequestModel;
import models.AddBookResponse;
import models.IsbnBookModel;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static specs.ApiSpecs.requestSpec;
import static specs.ApiSpecs.statusCode201Spec;

public class AddBookApi {
    @Step("Добавление новой книги через API")
    public void addBook(String isb, String token, String userId) {

        List<IsbnBookModel> books = new ArrayList<>();
        books.add(new IsbnBookModel(isb));

        AddBookRequestModel bookData = new AddBookRequestModel();
        bookData.setUserId(userId);
        bookData.setCollectionOfIsbns(books);
        given(requestSpec)
                .header("Authorization", "Bearer " + token)
                .body(bookData)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(statusCode201Spec)
                .extract().as(AddBookResponse.class);
    }
}
