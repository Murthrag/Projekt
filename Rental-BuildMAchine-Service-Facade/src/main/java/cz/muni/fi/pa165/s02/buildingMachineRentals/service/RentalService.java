/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.service;

import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.CustomerDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.MachineDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.dto.RentalDTO;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Machine;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janko
 */
public interface RentalService {

    public void addReturnDate(Rental rent, Date returnDate);
    public Rental getRentalByID(Long id);
    public List<Rental> getRentalsWithMachine(MachineDTO machine);
    public List<Rental> getRentalsWithCustomer(CustomerDTO customer);
    public List<Rental> findAllReturnedRentals();
    public List<Rental> FindRentalsFromDate(Date date);
    public List<Rental> findAllRentals();
}
