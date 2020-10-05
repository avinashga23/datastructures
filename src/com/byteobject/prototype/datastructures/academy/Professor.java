package com.byteobject.prototype.datastructures.academy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Professor extends Person {

    private Set<Course> coursesTeached = new HashSet<>();

    public Professor(int id, String name, String email, Date dateOfBirth, Gender gender) {
        super(id, name, email, dateOfBirth, gender);
    }

    public void teachCourse(Course course) {
        coursesTeached.add(course);
        if (!course.hasTeacher(this))
            course.addTeacher(this);
    }

    public boolean isTeaching(Course course) {
        return coursesTeached.contains(course);
    }

    public void addBonus(int amount) {
        System.out.println("Received Bonus " + amount);
    }

    public long getCoursesTeachedCount(int year) {
        return coursesTeached.stream().filter(c -> c.getStartDate().getYear() == year).count();
    }
}
