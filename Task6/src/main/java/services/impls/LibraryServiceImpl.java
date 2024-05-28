package services.impls;

import models.Book;
import models.Person;
import services.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static models.Library.libraryUsersOnPriorityQueue;
import static models.Library.libraryUsersOnQueue;

public class LibraryServiceImpl implements LibraryService {
    BookServiceImpl bookService = new BookServiceImpl();

    @Override
    public String addLibraryUsersToPriorityQueue(Person user) {
        libraryUsersOnPriorityQueue.add(user);
        return user.getName();
    }

    @Override
    public String addLibraryUsersToQueue(Person user) {
        libraryUsersOnQueue.add(user);
        return user.getName();
    }

    @Override
    public String giveBookByPriority(String book, List<Book> books) {
        libraryUsersOnPriorityQueue.forEach(
                p ->{
                    if(bookService.checkBook(book, books).isPresent()){
                        System.out.println(p.getName()+ " has borrowed " + book);
                    }else{
                        System.out.println(p.getName()+ " cannot borrow "+ book+ " because it is not available");
                    }
                }
        );
        return libraryUsersOnPriorityQueue.stream()
                .filter(p -> bookService.checkBook(book, books).isPresent())
                .map(p-> book )
                .findFirst()
                .orElse("");


    }

    @Override
    public String giveBookByOrder(String book, List<Book>books) {
        libraryUsersOnQueue.forEach(
                p ->{
                    if(bookService.checkBook(book, books).isPresent()){
                        System.out.println(p.getName()+ " has borrowed " + book);
                    }else{
                        System.out.println(p.getName()+ " cannot borrow "+ book+ " because it is not available");
                    }
                }
        );
        return libraryUsersOnPriorityQueue.stream()
                .filter(p -> bookService.checkBook(book, books).isPresent())
                .map(p-> book )
                .findFirst()
                .orElse("");
    }

    @Override
    public String returnBook(String nameOfBook, List<Book> books, Person user) {
//        for(Book b: books){
//            if(nameOfBook.equals(b.getName())){
//                b.setNumberOfCopies(b.getNumberOfCopies()+1);
//                System.out.println(user.getName()+ " has returned " +b.getName() +" to the Library");
//                return nameOfBook;
//            }
//        }
//
//        return nameOfBook+ "does not belong to this library";
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
