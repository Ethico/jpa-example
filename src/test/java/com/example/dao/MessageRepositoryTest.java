package com.example.dao;

import com.example.config.AppConfiguration;
import com.example.jpa.Application;
import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
/*
    This is simple integration test. Which uses in memory database H2.
    Instead of using @DataJpa we are using configuration provided in AppConfiguration.
*/
@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = AppConfiguration.class)
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;


    @Test
    public void testMessage() throws Exception{
        this.messageRepository.save(new Message("Sample Message"));
        Message message=this.messageRepository.findByMessage("Sample Message");
        assertThat(message).isNotNull();
        assertThat(message.getId()).isNotNull();
    }

    @Test
    public void testQueryMessage() throws Exception{
        this.messageRepository.save(new Message("Sample Message"));
        Message message=this.messageRepository.find("Sample Message");
        assertThat(message).isNotNull();
        assertThat(message.getId()).isNotNull();
    }



}
