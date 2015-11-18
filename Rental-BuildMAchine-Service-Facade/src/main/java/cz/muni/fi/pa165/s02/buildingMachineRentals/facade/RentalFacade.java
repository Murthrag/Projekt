/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.facade;

import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.CustomerDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.MachineDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.RentalDTO;
import java.util.List;
import java.util.Date;

/**
 *
 * @author janko
 */
public interface RentalFacade {
    
    public List<RentalDTO> getAllRentals();
    public List<RentalDTO> getRentalsFromDate(Date fromDate);
    public List<RentalDTO> getReturnedRentals();
    public List<RentalDTO> getRentalsFromCustomer(CustomerDTO customer);
    public List<RentalDTO> getRentalsWithMachine(MachineDTO machine);
    public RentalDTO getRentalByID(Long id);
    public Long createRental(RentalDTO rent);
    public void addReturnDate(RentalDTO rent, Date returnDate);
    
    
}
