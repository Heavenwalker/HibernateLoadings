package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateBiDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        //use session to save object
        try {

            int Id = 1 ;
            //begin transaction
            session.beginTransaction();

            //Get Instructor Detail
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,Id);

            //Get associated Instructor

            System.out.println(instructorDetail.getInstructor());

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        } catch(Exception ex){
            ex.printStackTrace();
        } finally {

            session.close();
            factory.close();

        }
    }
}
