package helpers;

import api.AuthorizationApi;
import io.qameta.allure.Step;
import models.book_store.AuthorizationResponseModel;
import org.openqa.selenium.Cookie;
import tests.BooksStoreTestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AddCookie extends BooksStoreTestBase {
    AuthorizationApi authApi = new AuthorizationApi();

    @Step("Добавить cookie авторизации в браузер")
    public AuthorizationResponseModel addCookie(){
        AuthorizationResponseModel auth = authApi.createNewUserTest();

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", auth.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", auth.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", auth.getExpires()));

        return auth;
    }



}
