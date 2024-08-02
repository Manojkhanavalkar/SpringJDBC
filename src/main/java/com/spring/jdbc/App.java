package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
//import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("My Program Started");
        //spring jdbc=> JdbcTemplate
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        /*	
         * THe below method before studentDao is not recommended not used in industry*/
//        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
//        String query="insert into student(id,name,city) values(?,?,?)";
        //Fire the query
//        int result = template.update(query,421,"Rammanohar Shastri","Mirzapur");
//        System.out.println("number of record inserted"+result);
          StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
          //getting bean 
          //here we can use the interface name directly as the ioc container will know the implementation class
          //by the class name we have provided in xml
          /* 	INSERT
           * below we are adding the values in the table
           * as shown */
//        Student student=new Student();
//        student.setId(234);
//        student.setName("Pratik Kulkarni");
//        student.setCity("pandharpur");
//        
//        int result=studentDao.insert(student);
//        System.out.println("insertion done of rows..."+result);
          
          //UPDATE
//        Student student=new Student();
//        student.setId(22);
//        student.setName("Rahul Bhave");
//        student.setCity("Satara");
//        int result=studentDao.change(student);
//        
//        System.out.println("Changes done:.."+result);
          
          //DELETE
          int result=studentDao.delete(22);
          System.out.println("Deleted=..."+result);
          
    }
}
