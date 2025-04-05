package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class BookModelResponse {
    @JsonProperty("publish_date")
    private String publishDate;

    private String isbn,title,subTitle,author,publisher,description,website;
    private Integer pages;
}
