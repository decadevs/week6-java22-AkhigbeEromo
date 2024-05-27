package models;

import enums.Gender;
import enums.Role;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    private final Role role;

    public Person(String name, int age, Gender gender, Role role) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }


    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + role +
                '}';
    }
}
