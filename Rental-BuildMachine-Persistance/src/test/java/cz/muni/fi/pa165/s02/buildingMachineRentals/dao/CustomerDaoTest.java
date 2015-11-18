/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Revision;
import cz.muni.fi.pa165.s02.buildingMachineRentals.main.PersistenceSampleApplicationContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Matus Backor
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CustomerDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerDao customerDao;
    
    private Customer c1;
    private Customer c2;

    @BeforeMethod
    public void setUp() {
        c1 = new Customer();
        c2 = new Customer();
        c1.setFirstname("John");
        c1.setSurname("Cena");
        c2.setFirstname("Randy");
        c2.setSurname("Orton");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 10, 28);
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        c1.setDateOfBirth(cal1.getTime());
        Calendar cal2 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        c2.setDateOfBirth(cal2.getTime());
        customerDao.addCustomer(c1);
    }

    @Test
    public void findAllTest() {
        customerDao.addCustomer(c2);

        List<Customer> customers = customerDao.findAll();
        Assert.assertEquals(customers.size(), 2);
        Customer c1test = new Customer();
        Customer c2test = new Customer();
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        Calendar cal2 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        c1test.setDateOfBirth(cal1.getTime());
        c2test.setDateOfBirth(cal2.getTime());
        c1test.setFirstname("John");
        c1test.setSurname("Cena");
        c2test.setFirstname("Randy");
        c2test.setSurname("Orton");

        Assert.assertTrue(customers.contains(c1test));
        Assert.assertTrue(customers.contains(c2test));
    }
    
    @Test
    public void addCustomerTest(){
        Assert.assertNotNull(c1.getId());
    }
    
    @Test
    public void deleteCustomerTest(){
        customerDao.deleteCustomer(customerDao.findCustomer(c1.getId()));
        Customer testCustomer = customerDao.findCustomer(c1.getId());
        Assert.assertNull(testCustomer);
        
    }
    
    @Test
    public void findCustomerTest(){
        Customer found = customerDao.findCustomer(c1.getId());
        assertNotNull(found);
        assertEquals(found.getFirstname(), "John");
        assertEquals(found.getSurname(), "Cena");
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        assertEquals(found.getDateOfBirth(), cal1.getTime());
    }
    
}
