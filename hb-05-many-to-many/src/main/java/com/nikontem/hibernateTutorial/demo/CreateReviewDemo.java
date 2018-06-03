package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Course;
import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import com.nikontem.hibernateTutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        try {

            int Id = 1;

            //begin transaction

            session.beginTransaction();

            //create a course

            Course course = new Course("Pacman");

            //add some reviews

            course.addReview(new Review("Great course...loved it"));
            course.addReview(new Review("Great Job...loved it"));
            course.addReview(new Review("Great course...Keep it up"));
            course.addReview(new Review("Great course...needs improvement"));
            course.addReview(new Review("Sucks"));

            //save the course... leverage cascade
            System.out.println("Saving");
            session.save(course);


            session.getTransaction().commit();
            System.out.println("Done");

        } finally {

            session.close();
            factory.close();

        }

    }
}
