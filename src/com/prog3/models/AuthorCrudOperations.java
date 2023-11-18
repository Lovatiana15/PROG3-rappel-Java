package com.prog3.models;
import com.prog3.entites.Author;
import com.prog3.utils.CrudOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    private Connection connection; 

    public AuthorCrudOperations(Connection connection) {
        this.connection = connection;
    }

      @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM Author"; 

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String authorId = resultSet.getString("id");
                String authorName = resultSet.getString("name");
                String authorSex = resultSet.getString("sex");

                Author author = new Author(authorId, authorName, authorSex);
                authors.add(author);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving authors from the database : " + e.getMessage());
            e.printStackTrace();
        }

        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String query = "INSERT INTO Author (id, name, sex) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Author author : toSave) {
                preparedStatement.setString(1, author.getId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getSex());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred when saving authors in the database : " + e.getMessage());
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String query = "INSERT INTO Author (id, name, sex) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getSex());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error occurred while saving the author in the database : " + e.getMessage());
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String query = "DELETE FROM Author WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, toDelete.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error occurred when deleting the author from the database : " + e.getMessage());
            e.printStackTrace();
        }
        return toDelete;
    }
}
