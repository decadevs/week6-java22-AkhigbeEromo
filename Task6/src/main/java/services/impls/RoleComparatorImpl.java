package services.impls;

import enums.Role;
import models.Person;

import java.util.Comparator;

public class RoleComparatorImpl implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Comparator.comparingInt((Person p) -> p.getRole().ordinal())
                .compare(p1, p2);
    }
}
