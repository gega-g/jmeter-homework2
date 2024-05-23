package ge.tbc.tbcitacademy.data.bookstoreData;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BooksItem(

        @JsonProperty("website") String website,

        @JsonProperty("pages") int pages,

        @JsonProperty("subTitle") String subTitle,

        @JsonProperty("author") String author,

        @JsonProperty("isbn") String isbn,

        @JsonProperty("publisher") String publisher,

        @JsonProperty("description") String description,

        @JsonProperty("title") String title,

        @JsonProperty("publish_date") String publishDate
){
}