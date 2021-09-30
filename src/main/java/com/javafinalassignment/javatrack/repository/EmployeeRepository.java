package com.javafinalassignment.javatrack.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String>
{


    @Query(value = "select count(*) from employee e", nativeQuery = true)
    public int getRowCount();

    @Query(value = "select count(*) from employee e where e.generated_email like ?1%", nativeQuery = true)
     public int findByGenerated_Email(String email);

    @Query(value = "select employment_type from employee e where e.code=?1", nativeQuery = true)
    public String getEmployment_type(String type);


    @Query(value = "update employee set notice_period=?1 where code like ?2 ", nativeQuery = true)
    public void setNotice_period(String date,String id);

    @Query(value = "select count(*) from employee e where e.date_of_join=?1", nativeQuery = true)
    public int get_by_date(String date);

    @Query(value = "update employee set end_period=?1 where code like ?2", nativeQuery = true)
    public void setEndDate(String date,String id);

    @Query(value = "select count(*) from employee e where e.end_period=?1", nativeQuery = true)
    public int getByEndPeriod(String date);

    @Query(value = "select count(*) from employee e where e.date_of_join=?1", nativeQuery = true)
    public int getSameOnboardingDateEmployees(String date);

    @Query(value = "update employee set job_type=?1 where code like ?2", nativeQuery = true)
    public void setJob(String type,String id);

    @Query(value = "delete from employee e where e.end_period=?1", nativeQuery = true)
    public void deleteEmployee(String date);

    @Query(value = "update employee set experience=experience+1 where date_of_join like ?1", nativeQuery = true)
    public void updateRole(String type);

    @Query(value = "update employee set job_type=?1 where job_type=?2 and experience between 3 and 5", nativeQuery = true)
    public void updateSDE1(String new1,String old);

    @Query(value = "update employee set job_type=?1 where job_type=?2 and experience between 6 and 8", nativeQuery = true)
    public void updateSDE2(String new1,String old);

    @Query(value = "update employee set job_type=?1 where job_type=?2 and experience between 3 and 5", nativeQuery = true)
    public void updateSDET1(String new1,String old);

    @Query(value = "update employee set job_type=?1 where job_type=?2 and experience between 6 and 8", nativeQuery = true)
    public void updateSDET2(String new1,String old);

    @Query(value = "update employee set job_type=?1 where job_type like ?2% and experience between 9 and 10", nativeQuery = true)
    public void updateSDE3(String new1,String old);

    @Query(value = "update employee set job_type=?1 where job_type like ?2% and experience > 10 ", nativeQuery = true)
    public void updateTL(String new1,String old);

    @Query(value = "update employee set experience=experience+1 where date_of_join like ?1", nativeQuery = true)
    public void updateIntern(String type);

    @Query(value = "update employee set job_type=?1 where job_type like ?2% and experience > 8 ", nativeQuery = true)
    public void updateEight(String new1,String old);

    @Query(value = "select * from employee e where e.date_of_join like ?1 and e.employment_type like ?2 ", nativeQuery = true)
    public ArrayList<Employee> findByEmployment_type(String date, String type);

    @Query(value = "update employee set code=?2 and employment_type=?3 where job_type like ?1  ", nativeQuery = true)
    public void updateToFTE(String old,String new1,String emp);
















}
