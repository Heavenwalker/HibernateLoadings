package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Course;
import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

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

            int Id = 1;

            //begin transaction

            session.beginTransaction();

            //get Instructor

            Instructor instructor = session.get(Instructor.class,Id);

            //create courses

            Course course1 = new Course("Guitar");
            Course course2 = new Course("Vaping");


            //add courses to the instructor

            instructor.add(course1);
            instructor.add(course2);

            //save object

            session.save(course1);
            session.save(course2);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {

            session.close();
            factory.close();

        }

    }
}
