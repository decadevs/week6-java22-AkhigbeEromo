package services.impls;

import models.Book;
import models.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BookServiceImplTest {
BookServiceImpl bookService = new BookServiceImpl();
    @Test
    void checkBook_ifNull() {
        assertNull(bookService.checkBook("Dangerously", Library.getBookShelf()));
    }
    @Test
    void checkBook_ifNotNull() {
        assertNotNull(bookService.checkBook("Things fall Apart", Library.getBookShelf()));
    }

}