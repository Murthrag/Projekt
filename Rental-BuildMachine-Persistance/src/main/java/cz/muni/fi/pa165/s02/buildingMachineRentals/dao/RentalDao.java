package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
/**
 *
 * @author Jan Pastrnak
 */
public interface RentalDao {
    
    public void addRental(Rental rent);
    public void deleteRental(Rental rent);
    public void updateRental(Rental rent);
    public Rental findRental(int id);
    
}
