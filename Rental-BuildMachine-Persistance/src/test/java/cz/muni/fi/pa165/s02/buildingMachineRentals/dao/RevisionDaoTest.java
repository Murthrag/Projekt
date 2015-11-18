/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Revision;
import cz.muni.fi.pa165.s02.buildingMachineRentals.main.PersistenceSampleApplicationContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * @Jakub Smolar
 */


@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RevisionDaoTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private RevisionDao revisionDao;

    @Autowired
    private MachineDao machineDao;
    
    private Revision rev1;
    private Revision rev2;
    
    
    @BeforeMethod
    public void setUp(){
        rev1 = new Revision();
        rev1.setReviserName("Velky Pan");
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        rev1.setRevisionDate(cal1.getTime());
        
        rev2 = new Revision();
        rev2.setReviserName("Schwarzenegger");
        Calendar cal2 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11); 
        rev2.setRevisionDate(cal2.getTime());
        
        revisionDao.addRevision(rev1);
        revisionDao.addRevision(rev2);
    }
    
    @Test
    public void testCreate(){
        assertNotNull(rev1.getId());
    }

    @Test
    public void testDelete(){
        Revision found = revisionDao.findRevisionById(rev1.getId());
        assertNotNull(found);
        
        revisionDao.deleteRevision(found);
        assertNull(revisionDao.findRevisionById(found.getId()));
    }
    
    @Test
    public void testUpdate(){
        rev2.setReviserName("Prezident");
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 13);
        rev2.setRevisionDate(cal1.getTime());
        revisionDao.updateRevision(rev2);
        
        Revision found = revisionDao.findRevisionById(rev2.getId());
        assertNotNull(found);
        assertEquals(found.getReviserName(), "Prezident");
        assertEquals(found.getRevisionDate(), cal1.getTime());
    }
    
    @Test
    public void testFindById(){      
        Revision found = revisionDao.findRevisionById(rev1.getId());
        assertNotNull(found);
        assertEquals(found.getReviserName(), "Velky Pan");
        Calendar cal1 = new GregorianCalendar(2015, Calendar.NOVEMBER, 11);
        assertEquals(found.getRevisionDate(), cal1.getTime());
    }
}
