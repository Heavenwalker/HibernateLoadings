package com.nikontem.hibernateTutorial.entity;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;


    @ManyToOne(cascade =
            {CascadeType.DETACH, CascadeType.MERGE,
             CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH,
                           CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "course_student",
               joinColumns= @JoinColumn(name  = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }


public void addReview(Review review){

        if (reviews == null){
            reviews = new ArrayList<>();
        }
        else{
            reviews.add(review);
        }
}

public void addStudent(Student student){

        if (students == null){
            students = new ArrayList<>();
        }
        else {
            students.add(student);
        }
}


}
