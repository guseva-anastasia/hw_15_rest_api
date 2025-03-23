package tests;

import api.AddBookApi;
import api.DeletedBookApi;
import api.GetBookCollectionApi;
import helpers.AddCookie;
import org.junit.jupiter.api.DisplayName;
import models.book_store.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.BookStorePage;

public class BooksStoreTests extends BooksStoreTestBase {

    private final int BOOK_NO = 0;

    @DisplayName("Проверка удаления книги из профиля")
    @Test
    @Tag("book_store_tests")
    void removeItemFromListTest (){
        AddBookApi addBook = new AddBookApi();
        DeletedBookApi deletedBook = new DeletedBookApi();
        GetBookCollectionApi bookList = new GetBookCollectionApi();
        BookStorePage bookStorePage = new BookStorePage();
        AddCookie cookie = new AddCookie();
        AuthorizationResponseModel auth = cookie.addCookie();

        BooksCollectionResponse collection = bookList.requestBookCollection();

        final String isbn = collection.getBooks()[0].getIsbn();
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
