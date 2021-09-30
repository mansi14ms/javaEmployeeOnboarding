package com.javafinalassignment.javatrack.repository;
import com.javafinalassignment.javatrack.entity.User;
import com.javafinalassignment.javatrack.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.String;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class EmployeeRetreival{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRetreival(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;

    }



    public Info addDetails(Info info,User user,String category)
    {
         String job=" ";
        System.out.println("category="+category);
        if(category.compareTo("sde")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if (exp <= 2) {
                    job="SDE1";
                    employeeRepository.setJob("SDE1", info.getUnique_code());

                } else if (exp <= 5) {
                    job="SDE2";
                    employeeRepository.setJob("SDE2", info.getUnique_code());

                } else if (exp <= 8) {
                    job="SDE3";
                    employeeRepository.setJob("SDE3", info.getUnique_code());

                } else if (exp <= 10) {
                    job="Technology Lead";
                    employeeRepository.setJob("Technolgy Lead", info.getUnique_code());

                } else {
                    job="Enginnering Manager";
                    employeeRepository.setJob("Engineering Manager", info.getUnique_code());

                }

            }catch(Exception e)
            {

            }


        }
        else if(category.compareTo("sdet")==0)
        {
            try {
                int exp = user.getExperience();
                Optional<Employee> emp = employeeRepository.findById(info.getUnique_code());
                if (exp <= 2) {
                    job="SDET1";
                    employeeRepository.setJob("SDET1", info.getUnique_code());

                } else if (exp <= 5) {
                    job="SDET2";
                    employeeRepository.setJob("SDET2", info.getUnique_code());

                } else if (exp <= 8) {
                    job="SDET3";
                    employeeRepository.setJob("SDET3", info.getUnique_code());

                } else if (exp <= 10) {
                    job="Technology Lead";
                    employeeRepository.setJob("Technology Lead", info.getUnique_code());

                } else {
                    job="Enginnering Manager";
                    employeeRepository.setJob("Engineering Manager", info.getUnique_code());

                }
            }catch(Exception e)
            {

            }

        }
        else if(category.compareTo("it")==0)
        {
           int exp= user.getExperience();

           try {
               if (exp <= 8) {
                   job="IT Specialist";
                   employeeRepository.setJob("IT Specialist", info.getUnique_code());
               }
               else {
                   job="IT Head";
                   employeeRepository.setJob("IT Head", info.getUnique_code());
               }
           }catch(Exception e)
           {

           }


        }
        else if(category.compareTo("manager")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if (exp <= 5) {
                    job="APM";
                    employeeRepository.setJob("APM", info.getUnique_code());
                }
                else if (exp <= 10) {
                    job="PM";
                    employeeRepository.setJob("PM", info.getUnique_code());
                }
                else if (exp <= 15) {
                    job="SPM";
                    employeeRepository.setJob("SPM", info.getUnique_code());
                }
                else if (exp <= 20) {
                    job="DH";
                    employeeRepository.setJob("DH", info.getUnique_code());
                }
                else {
                    job="Director Delivery";
                    employeeRepository.setJob("Director Delivery", info.getUnique_code());
                }
            }catch(Exception e)
            {

            }

        }

        else if(category.compareTo("architect")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if ((exp <= 10) && (exp >= 5)) {
                    job="Technical Architect";
                    employeeRepository.setJob("Technical Architect", info.getUnique_code());
                }
                else if ((exp <= 15) && (exp >= 10)) {
                    job="STA";
                    employeeRepository.setJob("STA", info.getUnique_code());
                }
            }catch(Exception e)
            {

            }

        }

        else if(category.compareTo("recruitment")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if (exp <= 8) {
                    job="Recruitment Specialist";
                    employeeRepository.setJob("Recruitment Specialist", info.getUnique_code());
                }
                else {
                    job="Recruitment Head";
                    employeeRepository.setJob("Recruitment Head", info.getUnique_code());
                }
            }catch(Exception e)
            {

            }

        }
        else if(category.compareTo("hr")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if (exp <= 8) {
                    job="HR Executive";
                    employeeRepository.setJob("HR Executive", info.getUnique_code());
                }
                else {
                    job="HR Head";
                    employeeRepository.setJob("HR Head", info.getUnique_code());
                }
            }catch(Exception e)
            {

            }

        }
        else if(category.compareTo("finance")==0)
        {
            int exp= user.getExperience();
            Optional<Employee> emp= employeeRepository.findById(info.getUnique_code());
            try {
                if (exp <= 8) {
                    job="Finance Executive";
                    employeeRepository.setJob("Finance Executive", info.getUnique_code());
                }
                else {
                    job="Finance Head";
                    employeeRepository.setJob("Finance Head", info.getUnique_code());
                }
            }catch(Exception e)
            {

            }

        }

        if (job==null)
        return null;

        info.setJobRole(job);
        return info;



    }

    public Info save(User user,String employee_type) throws BadRequestException {

        String unique_code = "HOP";
        int k = employeeRepository.getRowCount();
        k = k + 1;
        String value = String.valueOf(k);
        if (value.length() == 1)
            value = "000" + value;
        else if (value.length() == 2)
            value = "00" + value;
        else if (value.length() == 3)
            value = "0" + value;

        String s1 = employee_type.substring(0, 3);
        String s2 = employee_type.substring(3).toLowerCase();
        System.out.println("s1=" + s1);
        System.out.println("s2=" + s2);
        if(s1.compareTo("FTE")==0)
        employee_type = s1;

        unique_code = unique_code +"-"+ user.getYear_of_join() +"-"+ employee_type +"-"+ value;

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
        String formattedDate = dateFormat.format(date);
        user.setDate_of_join(formattedDate);
        user.setMonth_of_join(formattedDate.substring(4, 5));
        user.setYear_of_join(formattedDate.substring(6));


        boolean result = employeeRepository.existsById(unique_code);

        if (result == true) {
            int n = k;
            int i;
            for (i = 0; i < n; i++) {
                k = i + 1;
                value = String.valueOf(k);
                if (value.length() == 1)
                    value = "000" + value;
                else if (value.length() == 2)
                    value = "00" + value;
                else if (value.length() == 3)
                    value = "0" + value;
                unique_code = unique_code +"-"+ user.getYear_of_join() +"-"+ employee_type + "-"+value;
                if (employeeRepository.existsById(unique_code))
                    continue;
                else
                    break;

            }

        }

        String email = user.getFirst_name().toLowerCase() + "." + user.getLast_name().toLowerCase() + "@" + "hoppipola.com";
        String email_raw = user.getFirst_name().toLowerCase() + "." + user.getLast_name().toLowerCase();
        int result_email = employeeRepository.findByGenerated_Email(email_raw);

        System.out.println("emptyp="+employee_type);

        if (result_email != 0)
        {

            email = user.getFirst_name().toLowerCase() + "." + user.getLast_name().toLowerCase() + (result_email) + "@" + "hoppipola.com";
            System.out.println("email");

        }
        System.out.println("email="+email);
        if((employee_type.compareTo("FTE")==0)&&(user.getExperience()<20))
        {
        if ((s2.compareTo("sde") == 0) || (s2.compareTo("sdet") == 0) || (s2.compareTo("architect") == 0) || (s2.compareTo("it") == 0) ||(s2.compareTo("architect") == 0))
        {
            if ((user.getDegree_graduation().compareTo("TECHNICAL") != 0) && (user.getDegree_post_graduation().compareTo("TECHNICAL") != 0))
                throw new BadRequestException("Education Criteria Unsatisfied");
            System.out.println("here");
        } else if ((s2.compareTo("manager") == 0)) {
            System.out.println("man="+user.getDegree_post_graduation());
            if (user.getDegree_post_graduation().compareTo("MANAGEMENT") != 0)
                throw new BadRequestException("Education Criteria Unsatisfied");

        } else if ((s2.compareTo("hr") == 0)) {
            if (user.getDegree_post_graduation().compareTo("HR") != 0)
                throw new BadRequestException("Education Criteria Unsatisfied");
        } else if ((s2.compareTo("recruitment") == 0)) {
            if (user.getDegree_graduation().compareTo("NA") == 0)
                throw new BadRequestException("Education Criteria Unsatisfied");

        } else if ((s2.compareTo("finance") == 0)) {
            if ((user.getDegree_graduation().compareTo("FINANCE") != 0) && (user.getDegree_post_graduation().compareTo("FINANCE") != 0))
                throw new BadRequestException("Education Criteria Unsatisfied");
        } else if ((s2.compareTo("architect") == 0)) {
            if ((user.getDegree_graduation().compareTo("TECHNICAL") != 0) && (user.getDegree_post_graduation().compareTo("TECHNICAL") != 0))
                throw new BadRequestException("Education Criteria Unsatisfied");
        }
        else
            throw new BadRequestException("Wrong Path");

    }

        Employee emp= new Employee(user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getPincode(), user.getState(), user.getCity(), user.getPrimary_contact_number(), user.getSecondary_contact_number(), user.getExperience(), user.getYear_graduation(),user.getPrevious_company(),user.getYear_post_graduation(),user.getDegree_graduation(),user.getDegree_post_graduation(),user.getCollege_of_graduation(),user.getCollege_of_post_graduation(),user.getDate_of_join(),user.getMonth_of_join(),user.getYear_of_join(),email,unique_code,employee_type,"","","");
        employeeRepository.save(emp);
        return  new Info(unique_code,email," ");
    }

    public int check(Day days) throws BadRequestException
    {
      Integer date= days.getDate_of_leaving();
      String id=days.getId();
      Calendar cal = Calendar.getInstance();
      Date dat=cal.getTime();
      DateFormat dateFormat = new SimpleDateFormat("dd:MM:YYYY");
      String formattedDate=dateFormat.format(dat);

      System.out.println("type="+employeeRepository.getEmployment_type(id));

         if(employeeRepository.getEmployment_type(id)==null)
             throw new BadRequestException("Invalid ID");
          if (employeeRepository.getEmployment_type(id).compareTo("FTE") == 0) {
              if (date < 45)
                  return 0;
              else {
                  cal.add(Calendar.DATE, date);
                  Date currentDatePlusOne = cal.getTime();
                  String st = dateFormat.format(currentDatePlusOne).toString();
                  try {
                      employeeRepository.setNotice_period(String.valueOf(date), id);

                  } catch (Exception e) {

                  }
                  try {
                      employeeRepository.setEndDate(st, id);
                  } catch (Exception e) {

                  }

                  return 1;

              }
          } else if (employeeRepository.getEmployment_type(id).compareTo("STE") == 0) {

              if (date < 30) {
                  return 0;
              } else {
                  cal.add(Calendar.DATE, date);
                  Date currentDatePlusOne = cal.getTime();
                  String st = dateFormat.format(currentDatePlusOne).toString();
                  try {
                      employeeRepository.setNotice_period(String.valueOf(date), id);

                  } catch (Exception e) {

                  }
                  try {
                      employeeRepository.setEndDate(st, id);
                  } catch (Exception e) {

                  }

                  return 1;
              }
          } else if (employeeRepository.getEmployment_type(id).compareTo("Intern") == 0) {
              if (date < 30)
                  return 0;
              else {
                  cal.add(Calendar.DATE, date);
                  Date currentDatePlusOne = cal.getTime();
                  String st = dateFormat.format(currentDatePlusOne).toString();
                  try {
                      employeeRepository.setNotice_period(String.valueOf(date), id);

                  } catch (Exception e) {

                  }
                  try {
                      employeeRepository.setEndDate(st, id);
                  } catch (Exception e) {

                  }

                  return 1;

              }
          }
          else
          return 2;
      }




    public int get_count(String date)
    {   int c=0;
        c=employeeRepository.get_by_date(date);
        return c;
    }

    public int get_end_date(String date)
    {
        int c=0;
        System.out.println("date in retrival="+date);
        c=employeeRepository.getByEndPeriod(date);
        return c;

    }

    public int getOnboardingDate(String date)
    {
        int c=0;
        c=employeeRepository.getSameOnboardingDateEmployees(date);
        return c;

    }








}
