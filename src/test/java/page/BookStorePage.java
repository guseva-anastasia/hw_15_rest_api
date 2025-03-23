package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookStorePage {
    final private SelenideElement mainHeader = $(".main-header"),
            deleteButton = $("#delete-record-undefined"),
            okButton = $("#closeSmallModal-ok"),
            consentBanner = $(".fc-consent-root");

    @Step("Открытие профиля")
    public BookStorePage openPage() {
        open("/profile");

        return this;
    }
    @Step("Проверка баннера")
    public BookStorePage googleConsent() {
        if (consentBanner.isDisplayed()) {
            consentBanner.$(byText("Consent")).click();
        }
        else{
            System.out.println("No consent banner");
        }
        return this;
    }

    @Step("Проверка, что в коллекции есть книга {title}")
    public BookStorePage checkForBook(String title) {
        $("[id='see-book-"+title+"']").shouldBe(visible);
        return this;
    }

    @Step("Удаление книги через UI")
    public BookStorePage deleteBook() {
        deleteButton.click();
        return this;
    }
    @Step("Подтверждение удаления книги")
    public BookStorePage confirmDelete() {
        okButton.click();
        Selenide.switchTo().alert().accept();
        Selenide.switchTo().parentFrame();
        return this;
    }
    @Step("Проверка, что в коллекции нет книги {title}")
    public BookStorePage checkTableBody(String title) {
        $("[id='see-book-"+title+"']").shouldNot(visible);
        return this;
    }

}
