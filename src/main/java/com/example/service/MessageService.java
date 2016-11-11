package com.example.service;

import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    Simple Service class which just calls the repository.
    Not included any business validation under this class.
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;


    public List<Message> messageList(){
        List<Message> messages = new ArrayList<Message>();
        for(Message message: messageRepository.findAll()){
            messages.add(message);
        }
        return messages;
    }

}
