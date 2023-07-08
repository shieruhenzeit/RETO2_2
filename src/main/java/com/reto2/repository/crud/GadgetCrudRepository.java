package com.reto2.repository.crud;

import com.reto2.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DAVID BELTRAN
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
}
