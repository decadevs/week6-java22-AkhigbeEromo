package services.impls;

import enums.Role;
import models.Person;

import java.util.Comparator;

public class RoleComparatorImpl implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        Role role1 = p1.getRole();
        Role role2 = p2.getRole();

        if (role1 == role2) {
            return 0;
        }

        if (role1 == Role.TEACHER) {
            return -1;
        }
        if (role2 == Role.TEACHER) {
            return 1;
        }

        if (role1 == Role.SENIOR_STUDENT) {
            return -1;
        }
        if (role2 == Role.SENIOR_STUDENT) {
            return 1;
        }

        // By default, if none of the above conditions are met,
        // one person is a Junior Student, and the other is not.
        return 0;

    }
}
