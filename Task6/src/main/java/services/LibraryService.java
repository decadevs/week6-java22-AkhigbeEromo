package services;

import models.Book;
import models.Person;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    String addLibraryUsersToQueue(Person user);
    Optional<Book> reduceBookCount(String nameOfBook, List<Book>books);
    String giveBookByPriority(String nameOfBook, List<Book>books);
    String giveBookByOrder(String nameOfBook,List<Book>books);
    String returnBook(String nameOfBook, List<Book>books, Person user);
}
