package services;

import models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> checkBook(String nameOfBook, List<Book> books);
}
