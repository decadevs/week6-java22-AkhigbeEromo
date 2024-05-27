package services.impls;

import models.Book;
import services.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public Book checkBook(String nameOfBook,List<Book>books) {
        Book book =null;
   for(Book b:books){
       if(nameOfBook.equals(b.getName()) && b.getNumberOfCopies()!= 0){
           b.setNumberOfCopies(b.getNumberOfCopies()-1);
           book = b;
       }
       else if (!books.contains(b)){
           System.out.println(nameOfBook+ " is not available at the moment, try again later");
       }
   }
        return book;
    }
}
