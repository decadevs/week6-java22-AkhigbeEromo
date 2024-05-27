import enums.Gender;
import enums.Role;
import models.Library;
import models.Person;
import services.impls.LibraryServiceImpl;



public class LibrarySystem {
    public static void main(String[] args) {

        LibraryServiceImpl libraryService = new LibraryServiceImpl();


        Person seniorStudent = new Person("David Abayomi", 25, Gender.MALE, Role.SENIOR_STUDENT);
        Person teacher = new Person("Eromosele Akhigbe",23, Gender.MALE,Role.TEACHER);
        Person juniorStudent= new Person("Veronica Adason", 30, Gender.FEMALE, Role.JUNIOR_STUDENT);


        libraryService.addLibraryUsersToQueue(seniorStudent);
        libraryService.addLibraryUsersToQueue(teacher);
        libraryService.addLibraryUsersToQueue(juniorStudent);


        libraryService.addLibraryUsersToPriorityQueue(seniorStudent);
        libraryService.addLibraryUsersToPriorityQueue(teacher);
        libraryService.addLibraryUsersToPriorityQueue(juniorStudent);

        System.out.println("#####################################################");
        System.out.println("GIVING BOOK BY PRIORITY");
        libraryService.giveBookByPriority("Living Dangerously", Library.getBookShelf());

        System.out.println("#####################################################");
        System.out.println("GIVING BOOK BY ORDER");
        libraryService.giveBookByOrder("Things fall Apart", Library.getBookShelf());

        System.out.println("#####################################################");
        System.out.println("RETURN BOOK");
        libraryService.returnBook("Things fall Apart", Library.getBookShelf(),teacher);

    }
}
