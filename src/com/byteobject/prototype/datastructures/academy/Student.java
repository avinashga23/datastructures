package com.byteobject.prototype.datastructures.academy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {

    private Set<Course> coursesEnrolled = new HashSet<>();

    public Student(int id, String name, String email, Date dateOfBirth, Gender gender) {
        super(id, name, email, dateOfBirth, gender);
    }

    public void enroll(Course course) {
        coursesEnrolled.add(course);
        if (!course.hasStudent(this))
            course.enrollStudent(this);
    }

    public boolean isEnrolled(Course course) {
        return coursesEnrolled.contains(course);
    }

    public int numberOfCoursesEnrolled() {
        return coursesEnrolled.size();
    }

    public Set<Course> getCoursesEnrolled() {
        return Set.copyOf(coursesEnrolled);
    }

    public boolean isFullTime() {
        return coursesEnrolled.size() > 2;
    }
}
