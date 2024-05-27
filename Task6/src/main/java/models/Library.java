package models;

import services.impls.RoleComparatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Library {
    public static List<Person> libraryUsersOnQueue= new ArrayList<>();
    public static PriorityQueue<Person> libraryUsersOnPriorityQueue =new PriorityQueue<>(new RoleComparatorImpl());
    public  static List<Book> bookshelf = new ArrayList<>();

    public static List<Book> getBookShelf(){
        bookshelf.add(new Book(1, "Things fall Apart", "Chinua Achebe", 1990,1));
        bookshelf.add(new Book(2, "the gods are mad", "Felix Achebe", 1996,2));
        bookshelf.add(new Book(3, "Beautiful ones are not yet born", "Caro White", 2020,5));
        bookshelf.add(new Book(4, "The Eternals", "Charles Wright", 2012,6));
        bookshelf.add(new Book(5, "Living Dangerously", "Darry Light", 2023,6));
        return bookshelf;
    }

}
