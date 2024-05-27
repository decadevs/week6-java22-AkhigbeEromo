package services;

import models.Book;

import java.util.List;

public interface BookService {

    Book checkBook(String nameOfBook, List<Book> books);
}
