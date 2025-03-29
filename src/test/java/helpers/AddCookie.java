package helpers;

import api.AuthorizationApi;
import io.qameta.allure.Step;
import models.AuthorizationResponseModel;
import org.openqa.selenium.Cookie;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class AddCookie extends TestBase {
    final AuthorizationApi authApi = new AuthorizationApi();

    @Step("Создать нового пользователя")
    public AuthorizationResponseModel addCookie() {
        AuthorizationResponseModel auth = authApi.createNewUserTest();
        step("Добавить cookie авторизации в браузер", () -> {
            open("/favicon.ico");
            getWebDriver().manage().addCookie(new Cookie("userID", auth.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("token", auth.getToken()));
            getWebDriver().manage().addCookie(new Cookie("expires", auth.getExpires()));
        });


        return auth;
    }


}
