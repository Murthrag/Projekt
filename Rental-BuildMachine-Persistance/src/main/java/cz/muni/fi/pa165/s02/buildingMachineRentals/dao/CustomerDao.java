/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import java.util.List;

/**
 *
 * @Jakub Smolar
 */
public interface CustomerDao {
    
    public void addCustomer(Customer customer);
    public void deleteCustomerById(int id) throws IllegalArgumentException;
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public Customer findCustomer(int id);
    public List<Customer> findAll();
    
}
