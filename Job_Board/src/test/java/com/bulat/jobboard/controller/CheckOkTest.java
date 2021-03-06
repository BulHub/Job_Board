package com.bulat.jobboard.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CheckOkTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSignUp() throws Exception {
        this.mockMvc.perform(get("/signUp"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void signUp() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/signUp"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
