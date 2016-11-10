package com.example.resource;

import com.example.jpa.Application;
import com.example.model.Message;
import com.example.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.*;
/**
 * Created by hrushikeshp on 11/10/2016.
 */

/* Note :
    We should be mocking service class.
    This test looks like a integration test
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = Application.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    public void testMessages() throws Exception{
        List<Message> mockMessages= new ArrayList<Message>();
        mockMessages.add(new Message("sample"));
        given(this.messageService.messageList()).willReturn(mockMessages);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
                .andDo(print())
                .andExpect(status().isFound());
    }


}
