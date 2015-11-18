/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.facade;

import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.CustomerDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.MachineDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.RentalDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import cz.muni.fi.pa165.s02.buildingMachineRentals.service.RentalService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author janko
 */
public class RentalFacadeImpl implements RentalFacade{

    @Autowired
    private RentalService RentalService;
    
    @Override
    public List<RentalDTO> getAllRentals() {
       return FacadeMapping.mapTo(RentalService.findAllRentals(),RentalDTO.class);
    }

    @Override
    public List<RentalDTO> getRentalsFromDate(Date fromDate) {
        return FacadeMapping.mapTo(RentalService.FindRentalsFromDate(fromDate),RentalDTO.class);
    }

    @Override
    public List<RentalDTO> getReturnedRentals() {
        return FacadeMapping.mapTo(RentalService.findAllReturnedRentals(), RentalDTO.class);
    }

    @Override
    public List<RentalDTO> getRentalsFromCustomer(CustomerDTO customer) {
        return FacadeMapping.mapTo(RentalService.getRentalsWithCustomer(customer), RentalDTO.class); 
    }

    @Override
    public List<RentalDTO> getRentalsWithMachine(MachineDTO machine) {
        return FacadeMapping.mapTo(RentalService.getRentalsWithMachine(machine), RentalDTO.class); 
    }

    @Override
    public RentalDTO getRentalByID(Long id) {
        return FacadeMapping.mapTo(RentalService.getRentalByID(id), RentalDTO.class);        
    }

    @Override
    public Long createRental(RentalDTO rent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addReturnDate(RentalDTO rent, Date returnDate) {
        RentalService.addReturnDate(FacadeMapping.mapTo(rent, Rental.class), returnDate);
    }
    
}
