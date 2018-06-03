package com.nikontem.hibernateTutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {


    public static void main(String[] args) {

        String jdUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";
        try{

            Connection myconn = DriverManager.getConnection(jdUrl,user,password);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
