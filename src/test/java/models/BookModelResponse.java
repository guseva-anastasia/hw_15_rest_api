package models;

import lombok.Data;

@Data
public class BookModelResponse {
    private String isbn,title,subTitle,author,publish_date,publisher,description,website;
    private Integer pages;
}
