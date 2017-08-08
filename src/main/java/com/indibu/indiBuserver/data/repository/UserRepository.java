package com.indibu.indiBuserver.data.repository;


import com.indibu.indiBuserver.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    User findByNickName(String nickName);

    User findByEmail(String email);

}
