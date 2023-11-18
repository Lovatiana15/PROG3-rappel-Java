package com.prog3;

import com.prog3.models.AuthorCrudOperations;
import com.prog3.models.BookCrudOperations;
import com.prog3.dbConnection.DatabaseConf;
import com.prog3.entites.Author;
import com.prog3.entites.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseConf conf = new DatabaseConf();
        
        // Test BookCrudOperations
        BookCrudOperations bookCrud = new BookCrudOperations(conf.getConnection());
        List<Book> books = bookCrud.findAll();
        System.out.println("List of book :");
        for (Book book : books) {
            System.out.println(book);
        }
        
       // AuthorCrudOperations test
        AuthorCrudOperations authorCrud = new AuthorCrudOperations(conf.getConnection());
        List<Author> authors = authorCrud.findAll();
        System.out.println("List of author :");
        for (Author author : authors) {
            System.out.println(author);
        }
    }
}
