package com.javafinalassignment.javatrack.controllers;
import com.javafinalassignment.javatrack.entity.User;
import com.javafinalassignment.javatrack.exception.BadRequestException;
import com.javafinalassignment.javatrack.repository.Day;
import com.javafinalassignment.javatrack.repository.Employee;
import com.javafinalassignment.javatrack.repository.Info;
import com.javafinalassignment.javatrack.service.EmployeeSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private EmployeeSevice employeeService;

    @Autowired
    public MainController(EmployeeSevice employeeSevice)
    {
        this.employeeService=employeeSevice;
    }

    private static Logger log = LoggerFactory.getLogger(MainController.class);


    @RequestMapping("/")
    public String helloWorld()
    {
        return "Welcome to Employee Data Portal";
    }


    @GetMapping("/employee/{id}")                                   // API to retreive the details of particular id
    public Employee getById(@PathVariable("id") String id) throws BadRequestException
    {
        try {
            return employeeService.getById(id);
        }catch(Exception ex)
        {
            log.error("Not found", ex.getMessage());
            return null;
        }
    }

    @PostMapping("/onboard/FTE/SDE")                                    // API to onboard FTE SDE
    public Info create_fte(@RequestBody User user) throws BadRequestException
    {
       try {
           return employeeService.create(user, "FTESDE");
       }catch (Exception ex) {
           log.error("Error occurred", ex.getMessage());
           return null;
       }

    }
    @PostMapping("/onboard/FTE/SDET")                                    // API to onboard FTE's
    public Info create_fte_sdet(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTESDET");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/IT")                                    // API to onboard FTE's
    public Info create_fte_it(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTEIT");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/MANAGER")                                    // API to onboard FTE's
    public Info create_fte_manager(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTEMANAGER");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/HR")                                    // API to onboard FTE's
    public Info create_fte_hr(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTEHR");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/RECRUITMENT")                                    // API to onboard FTE's
    public Info create_fte_recruitment(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTERECRUITMENT");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/FINANCE")                                    // API to onboard FTE's
    public Info create_fte_finance(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTEFINANCE");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }
    @PostMapping("/onboard/FTE/ARCHITECT")                                    // API to onboard FTE's
    public Info create_fte_architect(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "FTEARCHITECT");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
        }

    }






    @PostMapping("/onboard/STE")                                     // API to onboard STE's
    public Info create_ste(@RequestBody User user) throws BadRequestException
    {
       try {
           return employeeService.create(user, "STE");
       }catch (Exception ex) {
           log.error("Error occurred", ex.getMessage());
           return null;
       }
    }

    @PostMapping("/onboard/Intern")                                 // API to onboard Interns
    public Info create_intern(@RequestBody User user) throws BadRequestException
    {
        try {
            return employeeService.create(user, "Intern");
        }catch (Exception ex) {
            log.error("Error occurred", ex.getMessage());
            return null;
    }

    }

    @PostMapping("/employee/resignation")                           // API to check user-resignation notice period
    public String resign_user(@RequestBody Day days)throws BadRequestException
    {
       int b=employeeService.check_if_vaild(days);
       if(b==2)
           return "Wrong ID";
       else if(b==1)
           return "ALl good!!";
       else
           return "Notice Period Violation";
    }

    @GetMapping("/employee/date/{date}")                            //API to count number of employees that joined on given date
    public String get_total_employees(@PathVariable("date") String date)
    {
        int get_data=employeeService.get_count_by_date(date);
        String st="Number of Employees that joined on "+date+"="+get_data;
        return st;

    }

    @GetMapping("/employee/endDate/{date}")                        //API to count employees leaving on same date
    public String sameEndNoticePeriod(@PathVariable("date") String date)
    {
        int get_data=employeeService.get_end_notice(date);
        String st="Number of Employees whose end date is "+date+"="+get_data;
        return st;

    }
    @GetMapping("/employee/onboardingDate/{date}")                 //API to count employees who onboarded on same date
    public String sameOnboardingDate(@PathVariable("date") String date)
    {
        int get_data=employeeService.getOnDate(date);
        String st="Number of Employees whose end date is "+date+"="+get_data;
        return st;

    }




}
