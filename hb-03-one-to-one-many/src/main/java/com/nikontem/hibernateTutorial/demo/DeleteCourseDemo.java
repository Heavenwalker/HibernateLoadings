package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Course;
import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        try {

            int theId = 10;

            //begin transaction

            session.beginTransaction();

            //Get Course

            Course delCourse = session.get(Course.class,theId);

            //Delete Course

            session.delete(delCourse);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {

            session.close();
            factory.close();

        }

    }
}
