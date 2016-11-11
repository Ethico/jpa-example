package com.example.repository;

import com.example.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message,Long> {
    /*
        Note :
        Spring data module automatically convert this method to
        query and also creates implementation at runtime.
     */
    Message findByMessage(final String message);

    /*
        Note :
        Custom query simple example to get message by content
     */
    @Query("select m from Message m where m.message = :message")
    Message find(@Param("message") String message);
}
