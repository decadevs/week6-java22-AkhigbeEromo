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
    void addLibraryUsersToQueue() {
        assertEquals("David Abayomi",libraryService.addLibraryUsersToQueue(seniorStudent));
    }


    @Test
    void reduceBookCount() {
        assertNotNull(libraryService.reduceBookCount("Living Dangerously", Library.getBookShelf()));
    }

    @Test
    void giveBookByPriority() {
        assertNotNull(libraryService.giveBookByPriority("Living Dangerously", Library.getBookShelf()));
    }


    @Test
    void giveBookByOrder() {
        assertNotNull(libraryService.giveBookByOrder("Dangerously", Library.getBookShelf()));
    }
}