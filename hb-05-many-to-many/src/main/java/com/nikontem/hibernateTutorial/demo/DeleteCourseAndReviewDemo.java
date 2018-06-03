package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Course;
import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import com.nikontem.hibernateTutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewDemo {

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

            int Id = 10;

            //begin transaction

            session.beginTransaction();

           //Get course

            Course course = session.get(Course.class,Id);

          //Delete review

            session.delete(course);

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {

            session.close();
            factory.close();

        }

    }
}
