package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        try {

            int Id = 1;

            //begin transaction

            session.beginTransaction();

            Course course = new Course("Algorithm Design");

            session.save(course);

            //create Students

            Student student1 = new Student("George","Allum","georgeall@gmail.com");
            Student student2 = new Student("holy","spirit","dove@holytrinity.com");

            session.save(student1);
            session.save(student2);




            session.getTransaction().commit();
            System.out.println("Done");

        } finally {

            session.close();
            factory.close();

        }

    }
}
