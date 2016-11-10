package com.example.repository;

import com.example.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hrushikeshp on 11/10/2016.
 */
public interface MessageRepository extends CrudRepository<Message,Long> {
}
