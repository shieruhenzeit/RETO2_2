package com.reto2.repository.crud;

import com.reto2.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DAVID BELTRAN
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    //Para seleccionar el usuario con el id maximo
    //Corresponde a esta consulta de mongodb: db.usuarios.find().limit(1).sort({$natural:-1})
    Optional<User> findTopByOrderByIdDesc();
}
