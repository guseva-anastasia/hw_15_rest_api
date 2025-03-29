package tests;

import api.AddBookApi;
import api.GetBookCollectionApi;
import helpers.AddCookie;
import models.AuthorizationResponseModel;
import models.BooksCollectionResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.BookStorePage;

public class BooksStoreTests extends TestBase {

    @DisplayName("Проверка удаления книги из профиля")
    @Test
    @Tag("book_store_tests")
    void removeItemFromListTest (){
        AddBookApi addBook = new AddBookApi();
        GetBookCollectionApi bookList = new GetBookCollectionApi();
        BookStorePage bookStorePage = new BookStorePage();
        AddCookie cookie = new AddCookie();
        AuthorizationResponseModel auth = cookie.addCookie();

        BooksCollectionResponse collection = bookList.requestBookCollection();

        final String isbn = collection.getBooks()[0].getIsbn();
        int BOOK_NO = 0;
        final String title = collection.getBooks()[BOOK_NO].getTitle();
        addBook.addBook(isbn, auth.getToken(), auth.getUserId());

        bookStorePage.openPage()
                .googleConsent()
                .checkForBook(title)
                .deleteBook()
                .confirmDelete()
                .checkTableBody(title);
    }

}
