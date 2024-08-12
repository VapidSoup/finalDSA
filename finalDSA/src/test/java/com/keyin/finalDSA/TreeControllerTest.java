package com.keyin.finalDSA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class TreeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEnterNumbers() throws Exception {
        mockMvc.perform(get("/enter-numbers"))
                .andExpect(status().isOk())
                .andExpect(view().name("enter-numbers"));
    }

    @Test
    public void testProcessNumbers() throws Exception {
        mockMvc.perform(post("/process-numbers")
                        .param("numbers", "5,3,8,1,4"))
                .andExpect(status().isOk())
                .andExpect(view().name("tree"));
    }

    @Test
    public void testPreviousTrees() throws Exception {
        mockMvc.perform(get("/previous-trees"))
                .andExpect(status().isOk())
                .andExpect(view().name("previous-trees"));
    }
}
