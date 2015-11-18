/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Machine;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import cz.muni.fi.pa165.s02.buildingMachineRentals.main.PersistenceSampleApplicationContext;
import java.util.Date;
import javax.persistence.EntityManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 *
 * @author Adrian Elgyutt
 */

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RentalDaoTest extends AbstractTestNGSpringContextTests{
    
    private Rental r2;
    
    @PersistenceContext
    public EntityManager em;
    
    @Autowired
    private RentalDao rentalDao;
    
    @Autowired
    private MachineDao machineDao;
    
    @Autowired
    private CustomerDao customerDao;
    
    @BeforeMethod
    public void setUp() {
        Machine m1 = new Machine();
        m1.setMachineNumber(47);
        m1.setPricePerDay(23.0);
        m1.setType("bulldozer");
        machineDao.addMachine(m1);
        Customer c1 = new Customer();
        c1.setFirstname("Jon");
        c1.setSurname("Snow");
        customerDao.addCustomer(c1);
        Date d1 = new Date(2015, 30, 10);
        Rental r1 = new Rental();
        r1.setCustomer(c1);
        r1.setMachine(m1);
        r1.setRentalDate(d1);
        Machine m2 = new Machine();
        m2.setMachineNumber(13);
        m2.setPricePerDay(29.0);
        m2.setType("excavator");
        machineDao.addMachine(m2);
        Customer c2 = new Customer();
        c2.setFirstname("Aegon");
        c2.setSurname("Targaryen");
        customerDao.addCustomer(c2);
        Date d2 = new Date(2015, 29, 10);
        r2 = new Rental();
        r2.setCustomer(c2);
        r2.setMachine(m2);
        r2.setRentalDate(d2);
        em.persist(r1);
        em.persist(r2);
    }
    

    @Test
    public void testAddRental(){
        Machine m3 = new Machine();
        m3.setMachineNumber(19);
        m3.setPricePerDay(17.0);
        m3.setType("truck");
        machineDao.addMachine(m3);
        Customer c3 = new Customer();
        c3.setFirstname("Jon");
        c3.setSurname("Connington");
        customerDao.addCustomer(c3);
        Date d3 = new Date(2015, 28, 10);
        Rental r3 = new Rental();
        r3.setCustomer(c3);
        r3.setMachine(m3);
        r3.setRentalDate(d3);
        rentalDao.addRental(r3);
        Rental result = rentalDao.findRental(r3.getId());
        assertEquals(r3, result);
    }
    
    @Test
    public void testDeleteRental(){
        Machine m4 = new Machine();
        m4.setMachineNumber(31);
        m4.setPricePerDay(37.0);
        m4.setType("truck");
        machineDao.addMachine(m4);
        Customer c4 = new Customer();
        c4.setFirstname("Jon");
        c4.setSurname("Con");
        customerDao.addCustomer(c4);
        Date d4 = new Date(2015, 27, 10);
        Rental r4 = new Rental();
        r4.setCustomer(c4);
        r4.setMachine(m4);
        r4.setRentalDate(d4);
        rentalDao.addRental(r4);
        Rental result = rentalDao.findRental(r4.getId());
        assertNotNull(result);
        rentalDao.deleteRental(r4);
        result = rentalDao.findRental(r4.getId());
        assertNull(result);
    }
    
    @Test
    public void testFindRental(){
        Rental result = rentalDao.findRental(r2.getId());
        assertEquals(result, r2);
    }
    /*@BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }*/
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
