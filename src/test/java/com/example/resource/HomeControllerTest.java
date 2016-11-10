package com.example.resource;

import com.example.config.AppConfiguration;
import com.example.jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by hrushikeshp on 11/10/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
/*
   Note : ContextConfiguration is required here and it should point to
          class annotated with @ComponentScan. It does not work if we
          provide the class annotated with @Configuration
*/
@ContextConfiguration(classes = Application.class)
public class HomeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHome() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                            .andDo(print())
                .andExpect(status().isOk());
    }


}
