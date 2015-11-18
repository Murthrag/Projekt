package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Revision;

/**
 *
 * @author Matus Backor
 */
public interface RevisionDao {

    public void addRevision(Revision revision);

    public void deleteRevision(Revision revision);

    public void updateRevision(Revision revision);

    public Revision findRevisionById(int id);
}
