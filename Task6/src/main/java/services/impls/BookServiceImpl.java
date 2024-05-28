package services.impls;

import models.Book;
import services.BookService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Override
    public Optional<Book> checkBook(String nameOfBook,List<Book>books) {
        Optional<Book> optionalBook = books.stream()
                .filter(b -> nameOfBook.equals(b.getName()) && b.getNumberOfCopies() > 0)
                .findFirst();

        optionalBook.ifPresent(book -> book.setNumberOfCopies(book.getNumberOfCopies() - 1));

        return optionalBook;
    }
}
