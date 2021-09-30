package com.javafinalassignment.javatrack.Scheduler;

import com.javafinalassignment.javatrack.repository.Employee;
import com.javafinalassignment.javatrack.repository.EmployeeRepository;
import com.javafinalassignment.javatrack.repository.EmployeeRetreival;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Component
public class TableUpdate {

    private static final Logger log = LoggerFactory.getLogger(TableUpdate.class);

    private EmployeeRepository employeeRepository;

    @Autowired
    public TableUpdate(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;

    }

   @Scheduled(cron="0 0 18 * * *")
    public void batchJobs()
   {
       Calendar cal = Calendar.getInstance();
       Date dat=cal.getTime();
       DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
       String formattedDate=dateFormat.format(dat);

       cal.add(Calendar.YEAR, -1);
       Date currentDatePlusOne = cal.getTime();
       String st = dateFormat.format(currentDatePlusOne).toString();

       employeeRepository.deleteEmployee(formattedDate);
       employeeRepository.updateRole(st);
       employeeRepository.updateSDE1("SDE2","SDE1");
       employeeRepository.updateSDE2("SDE3","SDE2");
       employeeRepository.updateSDET1("SDET2","SDET1");
       employeeRepository.updateSDET2("SDET2","SDET1");
       employeeRepository.updateSDET2("SDET2","SDET1");
       employeeRepository.updateSDE3("Technology Lead","SDE");
       employeeRepository.updateTL("Engineering Manager","Technology Lead");
       employeeRepository.updateEight("IT Head","IT Specialist");
       employeeRepository.updateEight("STA","Technical Architect");
       employeeRepository.updateEight("Recruitment Head","Recruitment Specialist");
       employeeRepository.updateEight("HR Head","HR Executive");
       employeeRepository.updateEight("Finance Head","Finance Executive");

   }


    @Scheduled(cron="0 0 18 * * *")
    public void updates()
    {

        Calendar cal = Calendar.getInstance();
        Date dat=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
        String formattedDate=dateFormat.format(dat);

        cal.add(Calendar.MONTH, -6);
        Date currentDatePlusOne = cal.getTime();
        String st = dateFormat.format(currentDatePlusOne).toString();
        ArrayList<Employee> arr=new ArrayList<>();
        arr= employeeRepository.findByEmployment_type(st,"Intern");
        for(int i=0;i<arr.size();i++)
        {
            Employee emp=arr.get(i);
            String original_code=emp.getCode();
            String new_code=original_code.substring(0,9)+"FTE"+original_code.substring(14);
            employeeRepository.updateToFTE(original_code,new_code,"FTE");

        }





    }



}
