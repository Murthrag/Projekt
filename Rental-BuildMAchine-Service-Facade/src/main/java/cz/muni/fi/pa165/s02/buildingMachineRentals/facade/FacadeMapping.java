/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.facade;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author janko
 */
public class FacadeMapping {
   
   private static DozerBeanMapper dozer = new DozerBeanMapper();

   public static <T> List<T> mapTo(List<?> InputObjects, Class<T> mapToClass){
       List<T> collectionToMap = new ArrayList<>();
       for(Object object : InputObjects) {
           collectionToMap.add(dozer.map(object, mapToClass));          
       }
       return collectionToMap;
   } 
    
   public static <T> T mapTo(Object o, Class<T> mapToClass){
       return dozer.map(o, mapToClass);
   }
}
