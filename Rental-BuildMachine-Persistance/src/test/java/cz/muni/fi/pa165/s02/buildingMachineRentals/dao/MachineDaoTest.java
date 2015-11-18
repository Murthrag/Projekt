package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Machine;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Revision;
import cz.muni.fi.pa165.s02.buildingMachineRentals.main.PersistenceSampleApplicationContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author Jan Pastrnak
 */
//public class MachineDaoTest {}/*
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MachineDaoTest extends AbstractTestNGSpringContextTests{

    @PersistenceContext
    EntityManager em;
        
    @Autowired
    private MachineDao machineDao;    
    
    private Machine TestMachineBulldozer;
    private Machine TestMachineCrane;
    private Machine TestMachineTruck;
    
    private Revision Revision01;
    private Revision Revision02;
    
    private Rental RentNM001;
    private Rental RentNM002;
    
    
    @BeforeMethod
    public void setUp() {
        
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);        
        Revision01 = new Revision();
        Revision01.setReviserName("Bulldozer revision");
        Revision01.setRevisionDate(cal1.getTime());
        
        Calendar cal2 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);        
        Revision02 = new Revision();
        Revision02.setReviserName("Crane revision");
        Revision02.setRevisionDate(cal2.getTime());   
        
        TestMachineBulldozer = new Machine();
        TestMachineBulldozer.setMachineNumber(254251541);
        TestMachineBulldozer.setPricePerDay(Double.valueOf("15000"));
        TestMachineBulldozer.setType("Surface changes, Big Engine");
        TestMachineBulldozer.setLastRevision(Revision01); 
        
        machineDao.addMachine(TestMachineBulldozer);
        
        TestMachineCrane = new Machine();
        TestMachineCrane.setMachineNumber(188877457);
        TestMachineCrane.setPricePerDay(Double.valueOf("110000"));
        TestMachineCrane.setType("Moving objects, Big Engine");
        TestMachineCrane.setLastRevision(Revision02);
                
        machineDao.addMachine(TestMachineCrane);  
        
        // no revision for this machine
        TestMachineTruck = new Machine();
        TestMachineTruck.setMachineNumber(54545151);
        TestMachineTruck.setPricePerDay(Double.valueOf("11000000"));
        TestMachineTruck.setType("Surface changes, Big Engine");
                
        machineDao.addMachine(TestMachineTruck);     
        
    }

    //Test if all objects were created and are accesiable

    @Test
    public void testCreate(){
        assertNotNull(machineDao.findMachineById(TestMachineBulldozer.getId()));
        assertNotNull(machineDao.findMachineById(TestMachineCrane.getId()));

       // assertNotNull(TestMachineTruck.getId());
    }

    //Tests for method findMachineById.

    @Test()
    public void testFindById() {

        Machine found = machineDao.findMachineById(TestMachineBulldozer.getId());
        assertEquals(found.getId(), TestMachineBulldozer.getId());
        assertEquals(found.getMachineNumber(), 254251541);
        assertEquals(found.getPricePerDay(),Double.valueOf("15000"));
        assertEquals(found.getLastRevision(), Revision01);
        
        Machine found2 = machineDao.findMachineById(TestMachineTruck.getId());
        assertEquals(found2.getId(), TestMachineTruck.getId()); 
        assertEquals(found2.getMachineNumber(), 54545151);
        assertEquals(found2.getPricePerDay(),Double.valueOf("11000000"));
        assertEquals(found2.getLastRevision(), null);      
    }

    // Testing method updateMachine    
    
    @Test
    public void testUpdate(){
        TestMachineBulldozer.setMachineNumber(1100211);
        TestMachineBulldozer.setPricePerDay(Double.valueOf("1105"));
        machineDao.updateMachine(TestMachineBulldozer);
        
        Machine found = machineDao.findMachineById(TestMachineBulldozer.getId());
        assertNotNull(found);
        assertEquals(found.getMachineNumber(), 1100211);
        assertEquals(found.getPricePerDay(), Double.valueOf("1105"));
    }
    
    @Test
    public void testDelete(){
        Machine found = machineDao.findMachineById(TestMachineBulldozer.getId());
        assertNotNull(found);
        
        machineDao.deleteMachine(found);
        assertNull(machineDao.findMachineById(found.getId()));
    }

}
