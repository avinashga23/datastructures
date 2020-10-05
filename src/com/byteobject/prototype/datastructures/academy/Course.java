package com.byteobject.prototype.datastructures.academy;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {

    private final int id;

    private final String name;

    private final int minStudentsRequired;

    private final int maxStudents;

    private Set<Professor> teachers = new HashSet<>();

    private LocalDate startDate;

    private Set<Student> students = new HashSet<>();

    public Course(int id, String name, int minStudentsRequired, int maxStudents) {
        this.id = id;
        this.name = name;
        this.minStudentsRequired = minStudentsRequired;
        this.maxStudents = maxStudents;
    }

    public boolean hasTeacher(Professor teacher) {
        return teachers.contains(teacher);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public void enrollStudent(Student student) {
        students.add(student);
        if (!student.isEnrolled(this))
            student.enroll(this);
    }

    public void addTeacher(Professor professor) {
        teachers.add(professor);
        if (!professor.isTeaching(this))
            professor.teachCourse(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinStudentsRequired() {
        return minStudentsRequired;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public Set<Professor> getTeachers() {
        return Set.copyOf(this.teachers);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
