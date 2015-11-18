/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.service;

import cz.muni.fi.pa165.s02.buildingMachineRentals.dao.RentalDao;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.CustomerDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.MachineDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author janko
 */
public class RentalServiceImpl implements RentalService{

    @Autowired
    private RentalDao rentalDao;
    
    @Override
    public void addReturnDate(Rental rent, Date returnDate) {
        rent.setReturnDate(returnDate);
        rentalDao.updateRental(rent);
    }

    @Override
    public Rental getRentalByID(Long id) {
        return rentalDao.findRental(id);        
    }

    @Override
    public List<Rental> getRentalsWithMachine(MachineDTO machine) {
        return null;
        //return rentalDao.findRentWithMachine(machine.getId());
    }

    @Override
    public List<Rental> getRentalsWithCustomer(CustomerDTO customer) {
        return null;
        //return rentalDao.getRentalsWithCustomer(customer.getId());
    }

    @Override
    public List<Rental> findAllReturnedRentals() {
        return rentalDao.findAllReturnedRentals();
    }

    @Override
    public List<Rental> FindRentalsFromDate(Date date) {
        return rentalDao.FindRentalsFromDate(date);
    }

    @Override
    public List<Rental> findAllRentals() {
        return rentalDao.findAll();
    }
    
}
