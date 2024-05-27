package services.impls;

import enums.Gender;
import enums.Role;
import models.Library;
import models.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    LibraryServiceImpl libraryService = new LibraryServiceImpl();
    Person seniorStudent = new Person("David Abayomi", 25, Gender.MALE, Role.SENIOR_STUDENT);


    @Test
    void addLibraryUsersToPriorityQueue() {
        assertEquals("David Abayomi",libraryService.addLibraryUsersToPriorityQueue(seniorStudent));
    }

    @Test
    void addLibraryUsersToQueue() {
        assertEquals("David Abayomi",libraryService.addLibraryUsersToQueue(seniorStudent));
    }

    @Test
    void giveBookByPriority_IfNull() {
        assertEquals("",libraryService.giveBookByPriority("Dangerously", Library.getBookShelf()));
    }
    @Test
    void giveBookByPriority_IfNotNull() {
        assertNotNull(libraryService.giveBookByPriority("Living Dangerously", Library.getBookShelf()));
    }

    @Test
    void giveBookByOrder_IfNull() {
        assertEquals("",libraryService.giveBookByOrder("Dangerously", Library.getBookShelf()));
    }
    @Test
    void giveBookByOrder_IfNotNull() {
        assertNotNull(libraryService.giveBookByOrder("Dangerously", Library.getBookShelf()));
    }
}