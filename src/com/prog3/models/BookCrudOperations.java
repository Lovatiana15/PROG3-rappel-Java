package com.prog3.models;

import com.prog3.entites.Author;
import com.prog3.entites.Book;
import com.prog3.utils.CrudOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    private Connection connection; 

    public BookCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT b.id, b.bookName, b.pageNumbers, b.topic, b.releaseDate, a.id as authorId, a.name as authorName, a.sex as authorSex " +
               "FROM Book b " +
               "JOIN Author a ON b.author_id = a.id";


        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String bookName = resultSet.getString("bookName");
                int pageNumbers = resultSet.getInt("pageNumbers");
                String topic = resultSet.getString("topic");
                String releaseDate = resultSet.getString("releaseDate");

                String authorId = resultSet.getString("authorId");
                String authorName = resultSet.getString("authorName");
                String authorSex = resultSet.getString("authorSex");

                Author author = new Author(authorId, authorName, authorSex);

                Book book = new Book(id, bookName, pageNumbers, topic, releaseDate, author);
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return books;
    }  
    @Override
    public List<Book> saveAll(List<Book> toSave) {
        return null;
    }

    @Override
    public Book save(Book toSave) {
        String query = "INSERT INTO Book (id, bookName, pageNumbers, topic, releaseDate, author_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getBookName());
            preparedStatement.setInt(3, toSave.getPageNumbers());
            preparedStatement.setString(4, toSave.getTopic());
            preparedStatement.setString(5, toSave.getReleaseDate());
            preparedStatement.setString(6, toSave.getAuthor().getId());
    
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Book successfully saved.");
                return toSave;
            } else {
                System.out.println("Book backup failed.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while saving the book : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    

    @Override
    public Book delete(Book toDelete) {
        String query = "DELETE FROM Book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, toDelete.getId());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Book deleted succefully");
                return toDelete;
            } else {
                System.out.println("No books matching this ID have been found.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while deleting the book. "+ e.getMessage());
            return null;
        }
    }
}
