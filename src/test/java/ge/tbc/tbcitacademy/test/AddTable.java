package ge.tbc.tbcitacademy.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.tbc.tbcitacademy.data.bookstoreData.BooksItem;
import ge.tbc.tbcitacademy.data.bookstoreData.BookstoreData;
import ge.tbc.tbcitacademy.data.steps.CreateTable;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AddTable {
    CreateTable createTable = new CreateTable();

    @Test
    public void table(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPath = "src/main/resources/books.json";
            BookstoreData bookstoreData = mapper.readValue(new File(jsonPath), BookstoreData.class);
            List<BooksItem> books = bookstoreData.books();
            createTable.insertBooks(books);
            System.out.println(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}