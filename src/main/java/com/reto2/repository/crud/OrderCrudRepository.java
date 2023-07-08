package com.reto2.repository.crud;

import com.reto2.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DAVID BELTRAN
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
