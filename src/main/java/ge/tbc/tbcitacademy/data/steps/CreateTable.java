package ge.tbc.tbcitacademy.data.steps;

import ge.tbc.tbcitacademy.data.bookstoreData.BooksItem;
import ge.tbc.tbcitacademy.data.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreateTable {
    public void insertBooks(List<BooksItem> books) {
        String SQL = "INSERT INTO dbo.books (isbn, title, subTitle, author, publish_date, publisher, pages, description, website) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            for (BooksItem book : books) {
                setPreparedStatement(preparedStatement, book);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPreparedStatement(PreparedStatement preparedStatement, BooksItem book) throws SQLException {
        preparedStatement.setString(1, book.isbn());
        preparedStatement.setString(2, book.title());
        preparedStatement.setString(3, book.subTitle());
        preparedStatement.setString(4, book.author());
        preparedStatement.setString(5, book.publishDate());
        preparedStatement.setString(6, book.publisher());
        preparedStatement.setInt(7, book.pages());
        preparedStatement.setString(8, book.description());
        preparedStatement.setString(9, book.website());
    }
}