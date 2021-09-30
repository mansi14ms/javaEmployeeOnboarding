package com.javafinalassignment.javatrack.service;

import com.javafinalassignment.javatrack.controllers.MainController;
import com.javafinalassignment.javatrack.entity.User;
import com.javafinalassignment.javatrack.exception.BadRequestException;
import com.javafinalassignment.javatrack.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeSevice
{

    private EmployeeRetreival employeeRetreival;
    private EmployeeRepository employeeRepository;

    private static Logger log = LoggerFactory.getLogger(EmployeeSevice.class);

    @Autowired
    public EmployeeSevice(EmployeeRepository employeeRepository,EmployeeRetreival employeeRetreival)
    {
        this.employeeRepository = employeeRepository;
        this.employeeRetreival=employeeRetreival;
    }


     public Employee getById(String id)throws BadRequestException
     {

         Optional<Employee> emp= employeeRepository.findById(id);
         if(emp == null) {
             throw new BadRequestException("User with id  not found");
         }
         return emp.get();
     }


     public Info create(User user,String employee_type)throws BadRequestException
     {
         try {

             String s1 = employee_type.substring(0, 3);
             String s2 = employee_type.substring(3).toLowerCase();

             System.out.println("employ_type="+employee_type);
             Info info = employeeRetreival.save(user, employee_type);
             System.out.println("info="+info);
             Info inf=info;
             if (s1.compareTo("FTE") == 0)
             {
                 inf=employeeRetreival.addDetails(info, user, s2);
                 System.out.println("inff="+inf);
             }
             return inf;
         }catch(BadRequestException ex){
             log.error("Not found", ex.getMessage());
             return null;

     }
     }

    
     public int check_if_vaild(Day days)throws BadRequestException
     {
        try {
            return employeeRetreival.check(days);
        }
        catch(BadRequestException ex)
        {
            return 2;
        }
     }

    public int get_count_by_date(String date)
    {

        return employeeRetreival.get_count(date);

    }

    public int get_end_notice(String date)
    {

        return employeeRetreival.get_end_date(date);

    }

    public int getOnDate(String date)
    {

        return employeeRetreival.getOnboardingDate(date);

    }





}
