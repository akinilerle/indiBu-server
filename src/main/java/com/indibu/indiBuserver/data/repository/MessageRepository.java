package com.indibu.indiBuserver.data.repository;


import com.indibu.indiBuserver.data.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {


}
