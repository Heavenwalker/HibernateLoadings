package com.nikontem.hibernateTutorial.demo;

import com.nikontem.hibernateTutorial.entity.Instructor;
import com.nikontem.hibernateTutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

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

            //create objects

            Instructor instructor =
                    new Instructor("Nikos","Ntemkas", "nikos@hotmail.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail(null,"relaxing");


            //associate objects
            instructor.setInstructorDetail(instructorDetail);
            //begin transaction

            session.beginTransaction();
            //save object
            session.save(instructor);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        }finally{

            session.close();
            factory.close();

        }



    }
}
