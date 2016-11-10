package com.example.resource;

import com.example.model.Message;
import com.example.repository.MessageRepository;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrushikeshp on 11/10/2016.
 */
/*
    Note :

    In this example we are using RestController annotation by which
    return object of any controller method will get converted into JSON
    by using Jackson Mapper.

 */
@RestController
public class MessageController {


    private MessageService messageService;
    /*
        TODO :
        Find out for spring junit testing why constructor injection is required
        why can't we autowired field directly ?
     */
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @RequestMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessage(){
        List<Message> messages=messageService.messageList();
        return new ResponseEntity<List<Message>>(messages, HttpStatus.FOUND);
    }

}
