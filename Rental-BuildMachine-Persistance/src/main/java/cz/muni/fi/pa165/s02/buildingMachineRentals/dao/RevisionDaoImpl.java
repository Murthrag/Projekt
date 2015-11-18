package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Revision;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matus Backor
 */
@Repository
public class RevisionDaoImpl implements RevisionDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addRevision(Revision revision) {
        em.persist(revision);
    }

    @Override
    public void deleteRevision(Revision revision) {
        em.remove(revision);
    }

    @Override
    public void updateRevision(Revision revision) {
        em.merge(revision);
    }

    @Override
    public Revision findRevisionById(int id) {
        return em.find(Revision.class, id);
    }
    
}
