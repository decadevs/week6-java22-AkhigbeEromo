package models;

public class Book {
    private final int id;
    private final String name;
    private final String author;
    private final int yearPublished;
    private int numberOfCopies;

    public Book(int id, String name, String author, int yearPublished, int numberOfCopies) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.numberOfCopies = numberOfCopies;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }
    public void setNumberOfCopies(int  numberOfCopies){
        this.numberOfCopies =numberOfCopies;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return "\n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n"+
                "Author: " + author + "\n" +
                "Year Published: " + yearPublished
                ;
    }
}
