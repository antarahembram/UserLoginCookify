package com.stackroute.userloginservice.userloginservice.repository;

import com.stackroute.userloginservice.userloginservice.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);
    DAOUser findByEmailId(String emailId);

}
