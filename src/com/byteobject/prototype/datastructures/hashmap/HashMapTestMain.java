package com.byteobject.prototype.datastructures.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTestMain {


    public static void main(String[] args) {
        Map<Person, String> personMap = new HashMap<>();

        Person person1 = new Person(1, "person1", "person1@people.com");
        Person person2 = new Person(2, "person2", "person2@people.com");
        Person person3 = new Person(3, "person3", "person3@people.com");
        Person person4 = new Person(4, "person4", "person4@people.com");
        Person person5 = new Person(5, "person5", "person5@people.com");
        Person person6 = new Person(6, "person6", "person6@people.com");
        Person person7 = new Person(7, "person7", "person7@people.com");
        Person person8 = new Person(8, "person8", "person8@people.com");
        Person person9 = new Person(9, "person9", "person9@people.com");
        Person person10 = new Person(10, "person10", "person10@people.com");
        Person person11 = new Person(11, "person11", "person11@people.com");
        Person person12 = new Person(11, "person11", "person12@people.com");
        Person person13 = new Person(13, "person13", "person13@people.com");
        Person person14 = new Person(14, "person14", "person14@people.com");
        Person person15 = new Person(15, "person15", "person15@people.com");
        Person person16 = new Person(16, "person16", "person16@people.com");
        Person person17 = new Person(17, "person17", "person17@people.com");
        Person person18 = new Person(18, "person18", "person18@people.com");
        Person person19 = new Person(19, "person19", "person19@people.com");
        Person person20 = new Person(20, "person20", "person20@people.com");

        personMap.put(person1, "person1");
        personMap.put(person2, "person2");
        personMap.put(person3, "person3");
        personMap.put(person4, "person4");
        personMap.put(person5, "person5");
        personMap.put(person6, "person6");
        personMap.put(person7, "person7");
        personMap.put(person8, "person8");
        personMap.put(person9, "person9");
        personMap.put(person10, "person10");
        personMap.put(person11, "person11");
        personMap.put(person12, "person12");
        personMap.put(person13, "person13");
        personMap.put(person14, "person14");
        personMap.put(person15, "person15");
        personMap.put(person16, "person16");
        personMap.put(person17, "person17");
        personMap.put(person18, "person18");
        personMap.put(person19, "person19");
        personMap.put(person20, "person20");

        System.out.println(personMap.get(person1));
        personMap.put(person1, "person1 updated");
        System.out.println(personMap.get(person1));
    }

    static class Person {

        private int id;

        private String name;

        private String email;

        public Person(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            var retVal = id == person.id &&
                    name.equals(person.name) &&
                    email.equals(person.email);
            return retVal;
        }

        @Override
        public int hashCode() {
            var retVal = Objects.hash(id, name);
            return retVal;
        }
    }

}
