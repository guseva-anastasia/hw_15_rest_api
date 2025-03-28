package models.book_store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BooksCollectionResponse {
    private BookModelResponse [] books;
}
