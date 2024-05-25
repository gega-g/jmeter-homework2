package ge.tbc.tbcitacademy.data.bookstoreData;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record BookstoreData(
        @JsonProperty("books") List<BooksItem> books
){
}