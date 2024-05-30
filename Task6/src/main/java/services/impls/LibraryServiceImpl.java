package services.impls;

import models.Book;
import models.Person;
import services.LibraryService;
import java.util.*;
import static models.Library.libraryUsersOnQueue;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public String addLibraryUsersToQueue(Person user) {
        libraryUsersOnQueue.add(user);
        return user.getName();
    }

    @Override
    public Optional<Book> reduceBookCount(String nameOfBook, List<Book> books) {
        Optional<Book> optionalBook = books.stream()
                .filter(b -> nameOfBook.equals(b.getName()) && b.getNumberOfCopies() > 0)
                .findFirst();

        optionalBook.ifPresent(book -> book.setNumberOfCopies(book.getNumberOfCopies() - 1));

        return optionalBook;
    }

    @Override
    public String giveBookByPriority(String book, List<Book> books) {
        libraryUsersOnQueue.sort(Comparator.comparing(Person::getRole));
        libraryUsersOnQueue.forEach(
                p ->{
                    if(reduceBookCount(book, books).isPresent()){
                        System.out.println(p.getName()+ " has borrowed " + book);
                    }else{
                        System.out.println(p.getName()+ " cannot borrow "+ book+ " because it is not available");
                    }
                }
        );
        return "Request handled";
    }

    @Override
    public String giveBookByOrder(String book, List<Book>books) {
        libraryUsersOnQueue.forEach(
                p ->{
                    if(reduceBookCount(book, books).isPresent()){
                        System.out.println(p.getName()+ " has borrowed " + book);
                    }else{
                        System.out.println(p.getName()+ " cannot borrow "+ book+ " because it is not available");
                    }
                }
        );
        return "Request handled";
    }

    @Override
    public String returnBook(String nameOfBook, List<Book> books, Person user) {
        Optional<Book> bookOptional = books.stream()
                .filter(b -> nameOfBook.equals(b.getName()))
                .findFirst();

        bookOptional.ifPresentOrElse(
                book -> {
                    book.setNumberOfCopies(book.getNumberOfCopies() + 1);
                    System.out.println(user.getName() + " has returned " + book.getName() + " to the Library");
                },
                () -> System.out.println(nameOfBook + " does not belong to this library")
        );

        return bookOptional.map(Book::getName).orElse(nameOfBook + " does not belong to this library");
    }
}
