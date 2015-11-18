package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Jan Pastrnak
 */
public interface RentalDao {
    
    public void addRental(Rental rent);
    public void deleteRental(Rental rent);
    public void updateRental(Rental rent);
    public Rental findRental(Long id);
    public List<Rental> findAll();          
    public List<Rental> findRentWithMachine(Long id);        
    public List<Rental> getRentalsWithCustomer(Long id);
    public List<Rental> findAllReturnedRentals();
    public List<Rental> FindRentalsFromDate(Date date);
}