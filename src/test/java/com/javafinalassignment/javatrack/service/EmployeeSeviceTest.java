package com.javafinalassignment.javatrack.service;

import com.javafinalassignment.javatrack.entity.User;
import com.javafinalassignment.javatrack.exception.BadRequestException;
import com.javafinalassignment.javatrack.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EmployeeSeviceTest {

    private EmployeeSevice employeeSevice;

    @Mock
    private EmployeeRetreival employeeRetreival;
    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeSevice = new EmployeeSevice(employeeRepository, employeeRetreival);
    }


    @Test
    void whenEmployeeCreationIsSuccessful() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","");
        Mockito.when(employeeRetreival.save(user, "FTESDE")).thenReturn(info);
        Info inf=new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","SDE1");
        Mockito.when(employeeRetreival.addDetails(info,user, "sde")).thenReturn(inf);

        // Act
        Info result = employeeSevice.create(user, "FTESDE");

        // Assert
        assertThat(result.getEmail(), equalTo("mansi.singh@hoppipolla.com"));
    }


    @Test
    void whenEmployeeIsFound() throws BadRequestException {
        // Arrange
        Employee employee = new Employee("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "2021", "2021", "dsce", "dsce", "2021", "2021", "2021", "mansi.singh@hoppipolla.com", "HOP2021FTE0001", "FTE", " ", " "," ");
        Mockito.when(employeeRepository.findById("HOP2021FTE0001")).thenReturn(java.util.Optional.of(employee));

        //Act
        Employee result = employeeSevice.getById("HOP2021FTE0001");

        //Assert
        assertThat(result.getFirst_name(), equalTo("mansi"));
        assertThat(result.getNotice_period(), equalTo(" "));
        assertThat(result.getGenerated_email(), equalTo("mansi.singh@hoppipolla.com"));
    }


    @Test
    void FindingResignationData() throws BadRequestException {
        // Arrange
        Day day = new Day(6,"HOP2021FTE0001");
        Mockito.when(employeeRetreival.check(day)).thenReturn(0);

        //Act
        int i = employeeSevice.check_if_vaild(day);

        //Assert
        assertThat(i, equalTo(0));

    }

    @Test
    void CountEmployeesOnboardedOnSameDate()  {
        // Arrange
        String date="23:03:2021";
        Mockito.when(employeeRetreival.getOnboardingDate(date)).thenReturn(3);

        //Act
        int i = employeeSevice.getOnDate(date);

        //Assert
        assertThat(i, equalTo(3));

    }
    @Test
    void CountEmployeesOnboardedOnGivenDate()  {
        // Arrange
        String date="29:06:2020";
        Mockito.when(employeeRetreival.get_count(date)).thenReturn(13);

        //Act
        int i = employeeSevice.get_count_by_date(date);

        //Assert
        assertThat(i, equalTo(13));

    }
    @Test
    void CountEmployeesLeavingOnSameDate()  {
        // Arrange
        String date="24:05:2020";
        Mockito.when(employeeRetreival.get_end_date(date)).thenReturn(3);

        //Act
        int i = employeeSevice.get_end_notice(date);

        //Assert
        assertThat(i, equalTo(3));

    }
    @Test
    void whenSTECreationIsNotSuccessful() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP2021FTE0001", "mansi.singh@hoppipolla.com","");
        Mockito.when(employeeRetreival.save(user, "STE")).thenReturn(info);

        // Act
        Info result = employeeSevice.create(user, "STE");

        // Assert
        assertThat(result.getEmail(), equalTo("mansi.singh@hoppipolla.com"));
    }
    @Test
    void whenEmployeeCreationIsNotSuccessful() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP2021FTE0001", "mansi.singh@hoppipolla.com","");
        Mockito.when(employeeRetreival.save(user, "FTE")).thenReturn(null);

        // Act
        Info result = employeeSevice.create(user, "FTE");

        // Assert
        assertThat(result, equalTo(null));
    }
    @Test
    void whenExceptionOccurs() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP2021FTE0001", "mansi.singh@hoppipolla.com","");
        Mockito.when(employeeRetreival.save(user, "FTEARCHI")).thenReturn(null);

        // Act
        Info result = employeeSevice.create(user, "FTE");

        // Assert
        assertThat(result, equalTo(null));
    }
    @Test
    void functionRunsSuccessfully() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHNICAL", "TECHNICAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","");
        Mockito.when(employeeRetreival.save(user, "FTESDE")).thenReturn(info);
        Info inf=new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","SDE1");
        Mockito.when(employeeRetreival.addDetails(info,user, "sde")).thenReturn(inf);

        // Act
        Info result = employeeSevice.create(user, "FTESDE");

        // Assert
        assertThat(result.getEmail(), equalTo("mansi.singh@hoppipolla.com"));
    }

    @Test
    void whenEmployeeIsNotFound() throws BadRequestException {
        // Arrange
        Employee employee = new Employee("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "2021", "2021", "dsce", "dsce", "2021", "2021", "2021", "mansi.singh@hoppipolla.com", "HOP2021FTE0004", "FTE", " ", " "," ");
        Mockito.when(employeeRepository.findById("HOP2021FTE0001")).thenReturn(java.util.Optional.of(employee));

        //Act
        try {
            Employee result = employeeSevice.getById("HOP2021FTE0001");
        }catch(Exception ex){

        //Assert

        assertThat(ex,null);
        }

    }

    @Test
    void whenCreateThrowsError() throws BadRequestException {
        // AAA Rule

        // Arrange
        User user = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHCAL", "TECHCAL", "dsce", "dsce", "2021", "2021", "2021");
        User mockedUser = new User("mansi", "singh", "bangalore", 12345L, "kar", "blore", 9999999L, 9999999L, 2, "helloo", "2021", "2021", "TECHCAL", "TECHCAL", "dsce", "dsce", "2021", "2021", "2021");
        Info info = new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","");

        Mockito.when(employeeRetreival.save(user, "FTESDE")).thenReturn(info);
        Info inf=new Info("HOP-2021-FTE-0001", "mansi.singh@hoppipolla.com","SDE1");
        Mockito.when(employeeRetreival.addDetails(info,user, "sde")).thenReturn(inf);

        // Act
        Info result = employeeSevice.create(user, "FTESDE");

        // Assert
        assertThat(result.getEmail(), equalTo("mansi.singh@hoppipolla.com"));
    }


















}