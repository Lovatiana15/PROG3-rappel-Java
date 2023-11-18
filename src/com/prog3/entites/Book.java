package com.prog3.entites;

public class Book {
    private String id;
    private String bookName;
    private int pageNumbers;
    private String topic;
    private String releaseDate;
    private Author author;

    public Book(String id, String bookName, int pageNumbers, String topic, String releaseDate, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", topic='" + topic + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", author=" + author +
                '}';
    }
}
