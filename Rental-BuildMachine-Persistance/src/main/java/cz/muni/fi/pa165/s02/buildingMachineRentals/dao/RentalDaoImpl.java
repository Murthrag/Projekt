/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Customer;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Machine;
import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Jan Pastrnak
 */
@Repository
@Transactional
public class RentalDaoImpl implements RentalDao {

    @PersistenceContext
    private EntityManager em;
        
    
    @Override
    public void addRental(Rental rent) {
        em.persist(rent);
    }

    @Override
    public void deleteRental(Rental rent) {
        em.remove(rent);
    }

    @Override
    public void updateRental(Rental rent) {
        em.merge(rent);
    }

    @Override
    public Rental findRental(Long id) {
        return em.find(Rental.class, id);
    }
    
    @Override
    public List<Rental> findAll(){
        return em.createQuery("select r from Rental r", Rental.class).getResultList();	
    }

    @Override
    public List<Rental> findRentWithMachine(Long id) {
	TypedQuery<Rental> query = em.createQuery( "SELECT r FROM Rental r WHERE r.machine.id = :machineID ", Rental.class );
	query.setParameter("machineID", id);
	return query.getResultList();
    }

    @Override
    public List<Rental> getRentalsWithCustomer(Long id) {
	TypedQuery<Rental> query = em.createQuery( "SELECT r FROM Rental r WHERE r.customer.id = :customerID", Rental.class );
	query.setParameter("customerID", id);
	return query.getResultList();  
    }

    @Override
    public List<Rental> findAllReturnedRentals() {
	return em.createQuery( "SELECT r FROM Rental r WHERE r.returnDate = IS NOT NULL ", Rental.class ).getResultList();
    }

    @Override
    public List<Rental> FindRentalsFromDate(Date date) {
    	TypedQuery<Rental> query = em.createQuery( "SELECT r FROM Rental r WHERE r.rentalDate >= :date", Rental.class );
	query.setParameter("date", date);
	return query.getResultList(); 
    }

}