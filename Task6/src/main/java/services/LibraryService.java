package services;

import models.Book;
import models.Person;

import java.util.List;

public interface LibraryService {
    String addLibraryUsersToPriorityQueue(Person user);
    String addLibraryUsersToQueue(Person user);
    String giveBookByPriority(String nameOfBook, List<Book>books);
    String giveBookByOrder(String nameOfBook,List<Book>books);
    String returnBook(String nameOfBook, List<Book>books, Person user);
}
