/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Jakub Smolar
 */

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    
    @PersistenceContext 
    private EntityManager em;

    @Override
    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public void deleteCustomerById(int id) throws IllegalArgumentException {
        em.remove(em.find(Customer.class, id));
    }
    
    @Override
    public void deleteCustomer(Customer customer) {
        em.remove(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }

    @Override
    public Customer findCustomer(int id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery( "SELECT c FROM Customer c", Customer.class );
	return query.getResultList();
    }
    
}
